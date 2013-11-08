#Set Partitioning

param m, integer, > 0;
param n, integer, > 0;

set I := {1 .. m};
set J := {1 .. n};

param partitions {i in I, j in J};

param c{j in J};

var x{j in J}, binary;

minimize cost: sum{j in J} c[j]*x[j];
s.t. Intersection {i in I} : sum{j in J} (partitions[i,j] * x[j]) = 1;

end;
