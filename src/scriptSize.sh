#!/bin/bash

echo "Execute Program 10 Times Every SetPartitioning"

for i in {1..10} 
	do  
		echo "--------------- Execution Time: $i --------------------"		
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/delta.txt 2 ../heuristic-size/delta.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/heart.txt 2 ../heuristic-size/heart.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/meteor.txt 2 ../heuristic-size/meteor.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppaa06.txt 2 ../heuristic-size/sppaa06.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw32.txt 2 ../heuristic-size/sppnw32.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw34.txt 2 ../heuristic-size/sppnw34.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw36.txt 2 ../heuristic-size/sppnw36.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw41.txt 2 ../heuristic-size/sppnw41.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw05.txt 2 ../heuristic-size/sppnw05.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw16.txt 2 ../heuristic-size/sppnw16.txt 100 0.05 50 1800
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppus01.txt 2 ../heuristic-size/sppus01.txt 100 0.05 50 1800
	done
