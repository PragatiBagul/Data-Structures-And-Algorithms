//Walking through a maze
/*
Given a grid of dimension N x M, you have to start from top left and reach the destination i.e.- the bottom right cell.
At each point you can either move right or down. Print and count all possible paths.
*/

import java.io.*;
import java.util.*;
public class MazeTraversal
{
    static int totalPaths = 0;
    public static void mazePath(int i,int j,int N,int M,String path)
    {
        if(i == N-1 && j == M-1)
        {
            //we have reached the destination
            ++totalPaths;
            System.out.println(path+"Destination");
            return;
        }
        if(i>=N || j>=M)
        {
            return;
        }
        mazePath(i, j+1, N, M, path+"R -> "); //Right move
        mazePath(i+1, j, N, M, path+"D -> "); //Down move
        mazePath(i+1, j+1, N, M, path+"Diagonal -> "); //Diagonal move
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        mazePath(0, 0, N, M, "");
        System.out.println("Total number of paths : "+totalPaths);
    }
}