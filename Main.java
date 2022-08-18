
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		String problemLine = null;
		//set try catch blocks to catch errors while reading a file
		try {
			//use buffered reader to read the input file
			BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
			problemLine = reader.readLine();
			StringTokenizer st1 = new StringTokenizer(problemLine);     // reading the p line separately to get the number of vertices and edges
			st1.nextToken();                                            
			int vertexCount = Integer.parseInt(st1.nextToken(" "));
			int edgeCount = Integer.parseInt(st1.nextToken(" "));
			
			//create adjacency matrix
			int[][] adjList = new int[vertexCount][vertexCount];
			
			while((problemLine = reader.readLine()) != null){
			
		        int vertex1, vertex2;
		        
		        // reading the edges from file & placing them into adjacency list
				    StringTokenizer st2 = new StringTokenizer(problemLine);
				    st2.nextToken();
				    vertex1 = Integer.parseInt(st2.nextToken(" "));
				    vertex2 = Integer.parseInt(st2.nextToken(" "));
				    
				    for(int i = 0; i < edgeCount; i++) {
				    adjList[vertex1-1][vertex2-1] = 1;
				    }
			
				}reader.close();
				
				// Loop through all rows
		        for (int i = 0; i < vertexCount; i++) {
		            // Loop through all elements of current row
		            for (int j = 0; j < vertexCount; j++) {
		            	if( adjList[i][j] != 1) {
		            		adjList[i][j] = 0;
		            	}
		            }
		    }
			//calculate the chromatic number
		         int chromatic = 1,temp=1;
				//create an array to hold the colors
				 int coloringOrder[] = new int[vertexCount];
				 coloringOrder[0] = 1;
					for(int i = 0; i < vertexCount; i++) {
						for (int j = 0; j < i; j++) {
							if( adjList[i][j] == 1) {
								coloringOrder[i]++;
								}
		        
							else{
								coloringOrder[i] = coloringOrder[j];
							}
					}
				}
					for(int i=0;i<vertexCount;i++) {
						if(coloringOrder[i]>temp) {
							temp = coloringOrder[i];
						}
					}
					chromatic = temp;
					color(1, chromatic, coloringOrder, adjList, vertexCount);
			
			
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	public static int[] color(int k, int chromaticNum, int[] colorArr, int[][] adjMatrix, int vertexNum) throws IOException{
		int max=1;
		if(k<vertexNum) {
			int i, j, restricted;
			int[] temp = new int[vertexNum];
			
			for(i = 0; i< chromaticNum; i++) {
				restricted = 0;
				for(j = 0; j<k; j++) {
					if(adjMatrix[k][j] == 1 && colorArr[j] == i) {
						restricted = 1;
						break;
					}
					else {
						restricted = 0;
					}
				} 
				if(restricted == 0) {
					for(j = 0; j < vertexNum; j++) {
						temp[j] = colorArr[j];
					}
					colorArr[k] = i;
					color(k+1, chromaticNum, colorArr, adjMatrix, vertexNum);
					
					for(j = 0; j < vertexNum; j++) {
						colorArr[j] = temp[j];
					}
				}
			}
		}
		else{
			
			for(int i=0;i<vertexNum;i++) {
				if(max<colorArr[i]) {
					max=colorArr[i];
				}
			}
			if(chromaticNum > max) {
				chromaticNum = max+1;
			}
			
			//create an output file and write the output into it
			File file = new File("output.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(chromaticNum);
			
			for(int i = 0; i < vertexNum; i++) {
				pw.print(colorArr[i] + " ");
		}
			pw.close();	//close the file
			
			System.exit(0); 
		}
		return colorArr;	//return the array which holds the color sequence
	}
}
