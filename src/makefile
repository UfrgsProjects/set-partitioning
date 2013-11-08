# Makefile para compilar e executar os códigos
# Pasta set-partitioning deve ser colocada dentro da home

compile:
	javac -d class *.java

execute:
	java -cp class SetPartition	

creat-datafiles:
	java -cp class -XX:MaxHeapSize=2048m -Xmx1024m MathProgDatConversor ../instancias ../glpk/dat
	
clean:
	rm class/*.class
