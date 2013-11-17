#!/bin/bash

echo "Execute Program 10 Times Every SetPartitioning"

for i in {1..10} 
	do  
		echo "--------------- Execution Time: $i --------------------"		
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/delta.txt 0 ../heuristic-feasible/delta.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/heart.txt 0 ../heuristic-feasible/heart.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/meteor.txt 0 ../heuristic-feasible/meteor.txt 1000 0.005 1000 
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppaa06.txt 0 ../heuristic-feasible/sppaa06.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw32.txt 0 ../heuristic-feasible/sppnw32.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw34.txt 0 ../heuristic-feasible/sppnw34.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw36.txt 0 ../heuristic-feasible/sppnw36.txt 1000 0.005 1000 
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw41.txt 0 ../heuristic-feasible/sppnw41.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw05.txt 0 ../heuristic-feasible/sppnw05.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppnw16.txt 0 ../heuristic-feasible/sppnw16.txt 1000 0.005 1000
		java -cp class:lib/guava-15.0.jar SetPartition ../instancias/sppus01.txt 0 ../heuristic-feasible/sppus01.txt 1000 0.005 1000
	done
