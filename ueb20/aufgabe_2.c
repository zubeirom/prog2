#include <stdio.h>
 
int fibbonacci(int n) {
   int prevprevnumber = 0; 
   int prevnumber = 0;
   int currentnumber = 1; 
 
   printf("%d ", currentnumber);
   for (int i = 1; i < n; i++) {
      prevprevnumber = prevnumber;
      prevnumber = currentnumber; 
      currentnumber = prevprevnumber + prevnumber; 
      printf("%d ", currentnumber);
   } 
   return currentnumber;
}
 
int main() {
   int n;
   printf("Bitte ganze Zahl eingeben: \n");
   scanf("%d", &n);
   printf("Fibbonacci of %d: " , n);
   
   int result = fibbonacci(n);
}