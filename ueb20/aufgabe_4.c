#include <stdio.h>

void increment(int num) {    
    printf("Bevor der wert verändert wird num=%d \n",num);    
    num = num + 5;
    printf("Nachdem der wert verändert wurde num=%d \n", num);    
}   

int main() {
    int x = 100;    
    printf("Vor dem Funktionsaufruf x=%d \n", x);
    increment(x);
    printf("Nach dem Funktionsaufruf x=%d \n", x);    
}
