///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bunkdeath.cube;
//
//import java.util.Iterator;
//import java.util.Vector;
//
///**
// *
// * @author root
// */
//public class RubikCube {
//
//    /** cube code input */
//    private String cubeCode;
//    /** size of cube 3*3*3 */
//    private int N = 3;
//    /** top face with values as indexed<br/>
//     *  1 2 3<br/>
//     *  4 5 6<br/>
//     *  7 8 9
//     */
//    Vector<String> top = new Vector<String>();
//    /** left face with values as indexed<br/>
//     *  1 2 3<br/>
//     *  4 5 6<br/>
//     *  7 8 9
//     */
//    Vector<String> left = new Vector<String>();
//    /** front face with values as indexed<br/>
//     *  1 2 3<br/>
//     *  4 5 6<br/>
//     *  7 8 9
//     */
//    Vector<String> front = new Vector<String>();
//    /** right face with values as indexed<br/>
//     *  1 2 3<br/>
//     *  4 5 6<br/>
//     *  7 8 9
//     */
//    Vector<String> right = new Vector<String>();
//    /** back face with values as indexed<br/>
//     *  1 2 3<br/>
//     *  4 5 6<br/>
//     *  7 8 9
//     */
//    Vector<String> back = new Vector<String>();
//    /** bottom face with values as indexed<br/>
//     *  1 2 3<br/>
//     *  4 5 6<br/>
//     *  7 8 9
//
//     */
//    Vector<String> bottom = new Vector<String>();
//
//    /**
//     * sets the cube code to process further
//     * @param cubeCode code combination from input cube
//     */
//    public RubikCube(String cubeCode) {
//        if (cubeCode.length() == N * N * 6) {
//            this.cubeCode = cubeCode;
//        } else {
//            System.out.println("Error in input string");
//            System.exit(1);
//        }
//    }
//
//    /**
//     * convert cube code string to array(vector array in this case)
//     */
//    public void cubeToArray() {
//        System.out.println(cubeCode);
//        top.add("");
//        left.add("");
//        front.add("");
//        right.add("");
//        back.add("");
//        bottom.add("");
//        int i = 1;
//        for (; i <= 1 * 9; i++) {
//            top.add(String.valueOf(cubeCode.charAt(i - 1)));
//        }
//        for (; i <= 2 * 9; i++) {
//            left.add(String.valueOf(cubeCode.charAt(i - 1)));
//        }
//        for (; i <= 3 * 9; i++) {
//            front.add(String.valueOf(cubeCode.charAt(i - 1)));
//        }
//        for (; i <= 4 * 9; i++) {
//            right.add(String.valueOf(cubeCode.charAt(i - 1)));
//        }
//        for (; i <= 5 * 9; i++) {
//            back.add(String.valueOf(cubeCode.charAt(i - 1)));
//        }
//        for (; i <= 6 * 9; i++) {
//            bottom.add(String.valueOf(cubeCode.charAt(i - 1)));
//        }
//    }
//
//    public void displayFaces() {
////        Iterator i;
////        i = top.iterator();
////        System.out.print("TOP\t");
////        while (i.hasNext()) {
////            System.out.print(i.next() + " ");
////        }
////        System.out.println("\n------------------------------------");
////        System.out.print("LEFT\t");
////        i = left.iterator();
////        while (i.hasNext()) {
////            System.out.print(i.next() + " ");
////        }
////        System.out.println("\n------------------------------------");
////        System.out.print("FRONT\t");
////        i = front.iterator();
////        while (i.hasNext()) {
////            System.out.print(i.next() + " ");
////        }
////        System.out.println("\n------------------------------------");
////        System.out.print("RIGHT\t");
////        i = right.iterator();
////        while (i.hasNext()) {
////            System.out.print(i.next() + " ");
////        }
////        System.out.println("\n------------------------------------");
////        System.out.print("BACK\t");
////        i = back.iterator();
////        while (i.hasNext()) {
////            System.out.print(i.next() + " ");
////        }
////        System.out.println("\n------------------------------------");
////        System.out.print("BOTTOM\t");
////        i = bottom.iterator();
////        while (i.hasNext()) {
////            System.out.print(i.next() + " ");
////        }
////        System.out.println("\n------------------------------------");
//        Object[] obj = getFaceObject();
//        System.out.printf("       %s %s %s\n"
//                        + "       %s %s %s\n"
//                        + "       %s %s %s\n"
//                        + "%s %s %s  %s %s %s  %s %s %s  %s %s %s\n"
//                        + "%s %s %s  %s %s %s  %s %s %s  %s %s %s\n"
//                        + "%s %s %s  %s %s %s  %s %s %s  %s %s %s\n"
//                        + "       %s %s %s\n"
//                        + "       %s %s %s\n"
//                        + "       %s %s %s\n"
//                        , obj);
//    }
//
//    public Object[] getFaceObject(){
//        Object[] temp = new Object[9*6];
//        int index = 0;
//        Iterator i;
//        i = top.iterator();
//        i.next();
//        while(i.hasNext())
//            temp[index++] = i.next().toString();
//        i = left.iterator();
//        i.next();
//        while(i.hasNext())
//            temp[index++] = i.next().toString();
//        i = front.iterator();
//        i.next();
//        while(i.hasNext())
//            temp[index++] = i.next().toString();
//        i = right.iterator();
//        i.next();
//        while(i.hasNext())
//            temp[index++] = i.next().toString();
//        i = back.iterator();
//        i.next();
//        while(i.hasNext())
//            temp[index++] = i.next().toString();
//        i = bottom.iterator();
//        i.next();
//        while(i.hasNext())
//            temp[index++] = i.next().toString();
//        return temp;
//    }
//
//    /**
//     * Rotates the cube clockwise
//     * @param position {top, bottom, left, right, front, back}
//     */
//    public void rotateClock(String position) {
//        boolean initialCondition = false;
//        String[] pos = {"left", "right", "top", "bottom", "front", "back"};
//        for (int i = 0; i < pos.length; i++) {
//            if (position.toLowerCase().equals(pos[i])) {
//                initialCondition = true;
//            }
//        }
//        if (!initialCondition) {
//            System.out.println("Error in position");
//            System.exit(1);
//        }
//
//
//    }
//
//    public void rotateLeftClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(1, top.get(1));
//        front.set(4, top.get(4));
//        front.set(7, top.get(7));
//
//        top.set(1, back.get(9));
//        top.set(4, back.get(6));
//        top.set(7, back.get(3));
//
//        back.set(3, bottom.get(7));
//        back.set(6, bottom.get(4));
//        back.set(9, bottom.get(1));
//
//        bottom.set(1, temp.get(1));
//        bottom.set(4, temp.get(4));
//        bottom.set(7, temp.get(7));
//
//        rotateFaceClock("left");
//    }
//
//    public void rotateLeftCounterClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(1, bottom.get(1));
//        front.set(4, bottom.get(4));
//        front.set(7, bottom.get(7));
//
//        bottom.set(1, back.get(9));
//        bottom.set(4, back.get(6));
//        bottom.set(7, back.get(3));
//
//        back.set(3, top.get(7));
//        back.set(6, top.get(4));
//        back.set(9, top.get(1));
//
//        top.set(1, temp.get(1));
//        top.set(4, temp.get(4));
//        top.set(7, temp.get(7));
//
//        rotateFaceCounterClock("left");
//    }
//
//    public void rotateRightClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(3, bottom.get(3));
//        front.set(6, bottom.get(6));
//        front.set(9, bottom.get(9));
//
//        bottom.set(3, back.get(7));
//        bottom.set(6, back.get(4));
//        bottom.set(9, back.get(1));
//
//        back.set(1, top.get(9));
//        back.set(4, top.get(6));
//        back.set(7, top.get(3));
//
//        top.set(3, temp.get(3));
//        top.set(6, temp.get(6));
//        top.set(9, temp.get(9));
//
//        rotateFaceClock("right");
//    }
//
//    public void rotateRightCounterClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(3, top.get(3));
//        front.set(6, top.get(6));
//        front.set(9, top.get(9));
//
//        top.set(3, back.get(7));
//        top.set(6, back.get(4));
//        top.set(9, back.get(1));
//
//        back.set(1, bottom.get(9));
//        back.set(4, bottom.get(6));
//        back.set(7, bottom.get(3));
//
//        bottom.set(3, temp.get(3));
//        bottom.set(6, temp.get(6));
//        bottom.set(9, temp.get(9));
//
//        rotateFaceCounterClock("right");
//    }
//
//    public void rotateTopClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(1, right.get(1));
//        front.set(2, right.get(2));
//        front.set(3, right.get(3));
//
//        right.set(1, back.get(1));
//        right.set(2, back.get(2));
//        right.set(3, back.get(3));
//
//        back.set(1, left.get(1));
//        back.set(2, left.get(2));
//        back.set(3, left.get(3));
//
//        left.set(1, temp.get(1));
//        left.set(2, temp.get(2));
//        left.set(3, temp.get(3));
//
//        rotateFaceClock("top");
//    }
//
//    public void rotateTopCounterClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(1, left.get(1));
//        front.set(2, left.get(2));
//        front.set(3, left.get(3));
//
//        left.set(1, back.get(1));
//        left.set(2, back.get(2));
//        left.set(3, back.get(3));
//
//        back.set(1, right.get(1));
//        back.set(2, right.get(2));
//        back.set(3, right.get(3));
//
//        right.set(1, temp.get(1));
//        right.set(2, temp.get(2));
//        right.set(3, temp.get(3));
//
//        rotateFaceCounterClock("top");
//    }
//
//    public void rotatebottomClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(7, right.get(7));
//        front.set(8, right.get(8));
//        front.set(9, right.get(9));
//
//        right.set(7, back.get(7));
//        right.set(8, back.get(8));
//        right.set(9, back.get(9));
//
//        back.set(7, left.get(7));
//        back.set(8, left.get(8));
//        back.set(9, left.get(9));
//
//        left.set(7, temp.get(7));
//        left.set(8, temp.get(8));
//        left.set(9, temp.get(9));
//
//        rotateFaceClock("bottom");
//    }
//
//    public void rotatebottomCounterClock() {
//        Vector<String> temp = clone(front);
//
//        front.set(7, left.get(7));
//        front.set(8, left.get(8));
//        front.set(9, left.get(9));
//
//        left.set(7, back.get(7));
//        left.set(8, back.get(8));
//        left.set(9, back.get(9));
//
//        back.set(7, right.get(7));
//        back.set(8, right.get(8));
//        back.set(9, right.get(9));
//
//        right.set(7, temp.get(7));
//        right.set(8, temp.get(8));
//        right.set(9, temp.get(9));
//
//        rotateFaceCounterClock("bottom");
//    }
//
//    public void rotateFrontClock() {
//        Vector<String> temp = clone(top);
//
//        top.set(7, left.get(9));
//        top.set(8, left.get(6));
//        top.set(9, left.get(3));
//
//        left.set(3, bottom.get(1));
//        left.set(6, bottom.get(2));
//        left.set(9, bottom.get(3));
//
//        bottom.set(1, right.get(7));
//        bottom.set(2, right.get(4));
//        bottom.set(3, right.get(1));
//
//        right.set(1, temp.get(7));
//        right.set(4, temp.get(8));
//        right.set(7, temp.get(9));
//
//        rotateFaceCounterClock("front");
//    }
//
//    public void rotateFrontCounterClock() {
//        Vector<String> temp = clone(top);
//
//        top.set(7, right.get(1));
//        top.set(8, right.get(4));
//        top.set(9, right.get(7));
//
//        right.set(1, bottom.get(3));
//        right.set(4, bottom.get(2));
//        right.set(7, bottom.get(1));
//
//        bottom.set(1, left.get(3));
//        bottom.set(2, left.get(6));
//        bottom.set(3, left.get(9));
//
//        left.set(3, temp.get(9));
//        left.set(6, temp.get(8));
//        left.set(9, temp.get(7));
//
//        rotateFaceCounterClock("front");
//    }
//
//    public void rotateBackClock() {
//        Vector<String> temp = clone(top);
//
//        top.set(1, left.get(7));
//        top.set(2, left.get(4));
//        top.set(3, left.get(1));
//
//        left.set(1, bottom.get(7));
//        left.set(4, bottom.get(8));
//        left.set(7, bottom.get(9));
//
//        bottom.set(7, right.get(9));
//        bottom.set(8, right.get(6));
//        bottom.set(9, right.get(3));
//
//        right.set(3, temp.get(1));
//        right.set(6, temp.get(2));
//        right.set(9, temp.get(3));
//
//        rotateFaceCounterClock("back");
//    }
//
//    public void rotateBackCounterClock() {
//        Vector<String> temp = clone(top);
//
//        top.set(1, right.get(3));
//        top.set(2, right.get(6));
//        top.set(3, right.get(9));
//
//        right.set(3, bottom.get(9));
//        right.set(6, bottom.get(8));
//        right.set(9, bottom.get(7));
//
//        bottom.set(7, left.get(1));
//        bottom.set(8, left.get(4));
//        bottom.set(9, left.get(7));
//
//        left.set(1, temp.get(3));
//        left.set(4, temp.get(2));
//        left.set(7, temp.get(1));
//
//        rotateFaceClock("back");
//    }
//
//    public void rotateCubeClock(){
//        Vector<String> temp = clone(front);
//
//        front = clone(right);
//        right = clone(back);
//        back = clone(left);
//        left = clone(temp);
//
//        rotateFaceClock(top);
//        rotateFaceCounterClock("bottom");
//    }
//    public void rotateFaceClock(Vector<String> face) {
//        Vector<String> current = face;
//        Vector<String> temp = clone(face);
//
////        String[] pos = {"left", "right", "top", "bottom", "front", "back"};
////
////        if (face.toLowerCase().equals(pos[0])) {
////            current = left;
////            temp = clone(left);
////        } else if (face.toLowerCase().equals(pos[1])) {
////            current = right;
////            temp = clone(right);
////        } else if (face.toLowerCase().equals(pos[2])) {
////            current = top;
////            temp = clone(top);
////        } else if (face.toLowerCase().equals(pos[3])) {
////            current = bottom;
////            temp = clone(bottom);
////        } else if (face.toLowerCase().equals(pos[4])) {
////            current = front;
////            temp = clone(front);
////        } else if (face.toLowerCase().equals(pos[5])) {
////            current = back;
////            temp = clone(back);
////        } else {
////            System.out.println("Error in face name");
////            System.exit(1);
////        }
//
//        current.set(1, temp.get(7));
//        current.set(2, temp.get(4));
//        current.set(3, temp.get(1));
//        current.set(4, temp.get(8));
//        current.set(5, temp.get(5));
//        current.set(6, temp.get(2));
//        current.set(7, temp.get(9));
//        current.set(8, temp.get(6));
//        current.set(9, temp.get(3));
//    }
//
//    public void rotateFaceCounterClock(Vector<String> face) {
//        Vector<String> current = face;
//        Vector<String> temp = clone(face);
//
////        String[] pos = {"left", "right", "top", "bottom", "front", "back"};
////
////        if (face.toLowerCase().equals(pos[0])) {
////            current = left;
////            temp = clone(left);
////        } else if (face.toLowerCase().equals(pos[1])) {
////            current = right;
////            temp = clone(right);
////        } else if (face.toLowerCase().equals(pos[2])) {
////            current = top;
////            temp = clone(top);
////        } else if (face.toLowerCase().equals(pos[3])) {
////            current = bottom;
////            temp = clone(bottom);
////        } else if (face.toLowerCase().equals(pos[4])) {
////            current = front;
////            temp = clone(front);
////        } else if (face.toLowerCase().equals(pos[5])) {
////            current = back;
////            temp = clone(back);
////        } else {
////            System.out.println("Error in face name");
////            System.exit(1);
////        }
//
//        current.set(1, temp.get(3));
//        current.set(2, temp.get(6));
//        current.set(3, temp.get(9));
//        current.set(4, temp.get(2));
//        current.set(5, temp.get(5));
//        current.set(6, temp.get(8));
//        current.set(7, temp.get(1));
//        current.set(8, temp.get(4));
//        current.set(9, temp.get(7));
//    }
//
//    /**
//     * Clones the given vector face
//     * @param face vector face
//     * @return cloned vector face
//     */
//    public Vector<String> clone(Vector<String> face) {
//        Vector<String> cloneVector = new Vector<String>();
//        Iterator i = face.iterator();
//        while (i.hasNext()) {
//            cloneVector.add(i.next().toString());
//        }
//        return cloneVector;
//    }
//
//    public void solve() {
//        solveBottomCross();
//
//    }
//
//    public void solveBottomCross() {
//        /** traks if move is done */
//        boolean move;
//        /** counts one if a complete move that was expected is made */
//        int packageMove = 0;
//        int index = 0;
//
//        String faceColor = getFaceColor(bottom);
//System.out.println("\t\t\t\t\t\t\t\tFACE COLOR : " + faceColor);
//
//        packageMove = matchedTopEdges(faceColor, top);
//        while (packageMove < 4) {
//System.out.println("\t\t\t\t\t\t\t\tPackage move : " + packageMove);
//            index = findColorOnEdge(faceColor, bottom);
//System.out.println("\t\t\t\t\t\t\t\tButtom Face color index: " + index);
//            if (index != 0 ) {
//                switch (index) {
//                    case 2:
//                        while (containsColorInIndexOfFace(faceColor, index, top)) {
//                            rotateTopClock();
//                            System.out.println("Rotate top clock");
//                        }
//                        rotateFrontClock();
//                        System.out.println("Rotate front clock");
//                        rotateFrontClock();
//                        System.out.println("Rotate front clock");
//                        packageMove++;
//displayFaces();
//                        break;
//                    case 4:
//                        while (containsColorInIndexOfFace(faceColor, index, top)) {
//                            rotateTopClock();
//                            System.out.println("Rotate top clock");
//                        }
//                        rotateLeftClock();
//                        System.out.println("Rotate left clock");
//                        rotateLeftClock();
//                        System.out.println("Rotate left clock");
//                        packageMove++;
//displayFaces();
//                        break;
//                    case 6:
//                        while (containsColorInIndexOfFace(faceColor, index, top)) {
//                            rotateTopClock();
//                            System.out.println("Rotate top clock");
//                        }
//                        rotateRightClock();
//                        System.out.println("Rotate right clock");
//                        rotateRightClock();
//                        System.out.println("Rotate right clock");
//                        packageMove++;
//displayFaces();
//                        break;
//                    case 8:
//                        while (containsColorInIndexOfFace(faceColor, index, top)) {
//                            rotateTopClock();
//                            System.out.println("Rotate top clock");
//                        }
//                        rotateBackClock();
//                        System.out.println("Rotate back clock");
//                        rotateBackClock();
//                        System.out.println("Rotate back clock");
//                        packageMove++;
//displayFaces();
//                        break;
//                }
//            }
//            index = findColorOnEdge(faceColor, front);
//System.out.println("\t\t\t\t\t\t\t\tFrong Face color index: " + index);
//            if (index != 0) {
//                switch (index) {
//                    case 2:
//                        move = false;
//                        do {
//                            if(!containsColorInIndexOfFace(faceColor, 4, top)){
//                                rotateFrontCounterClock();
//                                System.out.println("Rotate front counter clock");
//                                rotateLeftClock();
//                                System.out.println("Rotate left clock");
//packageMove++;
//displayFaces();
//                                move = true;
//                            }
//                            else if(!containsColorInIndexOfFace(faceColor, 6, top)){
//                                rotateFrontClock();
//                                System.out.println("Rotate front clock");
//                                rotateRightClock();
//                                System.out.println("Rotate right clock");
//packageMove++;
//displayFaces();
//                                move = true;
//                            }
//                            else{
//                                rotateTopClock();
//                                System.out.println("Rotate top clock");
//                            }
//                        } while (!move);
//                        break;
//                    case 4:
//                        move = false;
//                        do{
//                            if(!containsColorInIndexOfFace(faceColor, 4, top)){
//                                rotateRightClock();
//                                System.out.println("Rotate right clock");
//packageMove++;
//displayFaces();
//                                move = true;
//                            }
//                            else {
//                                rotateTopClock();
//                                System.out.println("Rotate top clock");
//                            }
//                        }while(!move);
//                        break;
//                    case 6:
//                        move = false;
//                        do{
//                            if(!containsColorInIndexOfFace(faceColor, 6, top)){
//                                rotateRightClock();
//                                System.out.println("Rotate right clock");
//packageMove++;
//displayFaces();
//                                move = true;
//                            }
//                            else {
//                                rotateTopClock();
//                                System.out.println("Rotate top clock");
//                            }
//                        }while(!move);
//                        break;
//                    case 8:
//                        move = false;
//                        if(!containsColorInIndexOfFace(faceColor, 8, top)){
//                            rotateFrontCounterClock();
//                            System.out.println("Rotate front clock");
//                            do{
//                                rotateTopClock();
//                                System.out.println("Rotate top clock");
//                            }while(!containsColorInIndexOfFace(faceColor, 6, top));
//                            rotateLeftClock();
//                            System.out.println("Rotate left clock");
//packageMove++;
//displayFaces();
//                        }
//                        break;
//                }
//            }
//            index = findColorOnEdge(faceColor, left);
//System.out.println("\t\t\t\t\t\t\t\tLeft Face color index: " + index);
//            if (index != 0) {
//                rotateCubeClock();
//                rotateCubeClock();
//                rotateCubeClock();
//                System.out.println("Rotate cube counter clock");
//                displayFaces();
//                System.out.println("Trying to continue");
//                continue;
//            }
//            index = findColorOnEdge(faceColor, right);
//System.out.println("\t\t\t\t\t\t\t\tRight Face color index: " + index);
//            if (index != 0) {
//                rotateCubeClock();
//                System.out.println("Rotate cube clock");
//                continue;
//            }
//            index = findColorOnEdge(faceColor, back);
//System.out.println("\t\t\t\t\t\t\t\tBack Face color index: " + index);
//            if (index != 0) {
//                rotateCubeClock();
//                System.out.println("Rotate cube clock");
//                rotateCubeClock();
//                System.out.println("Rotate cube clock");
//                continue;
//            }
//        }
//    }
//
//    public int matchedTopEdges(String colorCode, Vector<String> face) {
//        int ret = 0;
//        int[] index = {2, 4, 6, 8};
//        for (int i = 0; i < index.length; i++) {
//            if (face.get(index[i]).equals(colorCode)) {
//                System.out.println(index[i] + " : " + face.get(index[i]));
//                ret++;
//            }
//        }
//        return ret;
//    }
//
//    public int findColorOnEdge(String colorCode, Vector<String> face) {
//        int[] index = {2, 4, 6, 8};
//        for (int i = 0; i < index.length; i++) {
//            if (face.get(index[i]).equals(colorCode)) {
//                return index[i];
//
//            }
//        }
//        return 0;
//    }
//
//    public boolean containsColorInIndexOfFace(String colorCode, int index, Vector<String> face) {
//        if (face.get(index).equals(colorCode)) {
//            return true;
//        }
//        return false;
//    }
//
//    public void solveFirstLayer() {
//    }
//
//    public void solveSecondLayer() {
//    }
//
//    public void solveTopFace() {
//    }
//
//    public void solveTopEdges() {
//    }
//
//    public void solveLastLayer() {
//    }
//
//    public String getFaceColor(Vector<String> face) {
//        return face.get(5).toString();
//    }
//}


public class Test{
    public static void main(String[] args){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(j + " " + i);
                if(j==i){
                    break;
                }
                System.out.println("j not equals i");
            }
            System.out.println("j equals i");
        }
    }
}
