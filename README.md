# GraphColoringInJava

## Getting Started

Graph Coloring Problem is a well known NP hard problem, there are many different algorithms to get an optimal result for this problem.
The subject of this problem is to color a graph’s vertices such that no two adjacent vertices can share the same color and the
number of colors used is as minimal as possible. 
The number of the least possible colors to be used is called chromatic number. 
The lesser the chromatic number, the more successfull the algorithm.

## Description

A pattern is used which is similar to greedy approach to obtain an optimal solution for the problem.
The algorithm considers the vertices of the graph in sequence and assigns each vertex its first available color. It starts by coloring the first vertex in the graph and
continues to color others while checking that any two adjacent vertices do not have the same color. It stores the colors of each vertex in an array. Also, it counts the
number of colors that are used which should be as less as possible and, hold this value in a variable named chromatic number. 
The output of the code that is written is the chromatic number and the sequence of the color assignments of each vertex.
The efficiency of the code is basically determined by the success of the value of the chromatic number.

## How to Use

To successfully run the code you need an input (text) file in the correct format.
The format of the input file soud be:
p 'the number of vertices' 'the number of edges'  //represents the total number of vertices and edges in the graph
e 'the vertex number' 'the vertex number'         //meaning: there is an edge between these two vertices

  #### ex: [sample.txt](https://github.com/BetulAygunoglu/GraphColoringInJava/files/9371932/sample.txt)

Write the name of the input file (a text file) into the BufferedReader in the main function.
  #### ex: BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));

Make sure your input file is in the same directory as the java file.

To obtain the output you need to write the name of the output file (a text file) into the FileWriter in the color function.

  #### ex: File file = new File("output.txt");

The code is going to create the output file for you.
  #### ex: [output.txt](https://github.com/BetulAygunoglu/GraphColoringInJava/files/9371978/output.txt)

The total number of colors that are used (chromatic number) is written in the first line of the output file.
In the second line the color numbers displayed which are assigned to each vertex.

Check the output file to see if the code is runned successfully.
