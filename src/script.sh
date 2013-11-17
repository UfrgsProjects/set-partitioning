#!/bin/bash

echo "Execute Program 10 Times Every SetPartitioning"

for i in {1..10} 
	do  
		echo "--------------- Execution Time: $i --------------------"		
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/delta.txt 0 ../heuristic/delta.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/heart.txt 0 ../heuristic/heart.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/meteor.txt 0 ../heuristic/meteor.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppaa06.txt 0 ../heuristic/sppaa06.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw32.txt 0 ../heuristic/sppnw32.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw34.txt 0 ../heuristic/sppnw34.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw36.txt 0 ../heuristic/sppnw36.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw41.txt 0 ../heuristic/sppnw41.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw05.txt 0 ../heuristic/sppnw05.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw16.txt 0 ../heuristic/sppnw16.txt 10000 0.005
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppus01.txt 0 ../heuristic/sppus01.txt 10000 0.005
	done


