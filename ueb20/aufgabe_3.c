#include <stdio.h>
#include <limits.h>

void limitsUsingLib() {
    printf("Limits of datatypes using limit.h \n\n");

    printf("Min char = %d\n", CHAR_MIN);
    printf("Max char = %d\n", CHAR_MAX);
    printf("Unsigned char = %d\n\n", UCHAR_MAX);

    printf("Min short = %d\n", SHRT_MIN);
    printf("Max short = %d\n", SHRT_MAX);
    printf("Unsigned short = %d\n\n", USHRT_MAX); 

    printf("Min int = %d\n", INT_MIN);
    printf("Max int = %d\n", INT_MAX);
    printf("Unsigned int = %d\n\n", UINT_MAX);
}

void limits() {
    printf("Limits of datatypes \n\n");
    char max_char = 1;
    char min_char = 0;
    unsigned char unsigned_char = 0;
    
    while((char) (max_char+1) > 0) {
        max_char++;
    }

    while((char) (min_char-1) < 0) {
        min_char--;
    }

    while((unsigned char) (unsigned_char+1) > 0) {
        unsigned_char++;
    }

    short short_max = 1;
    short short_min = 0;
    unsigned short unsigned_short = 0;

    while((short) (short_max+1) > 0) {
        short_max++;
    }

    while((short) (short_min-1) < 0) {
        short_min--;
    }

    while((unsigned short) (unsigned_short+1) > 0) {
        unsigned_short++;
    }

    int int_max = 1;
    int int_min = 0;
    unsigned int unsigned_int = 0;

    while((int) (int_max+1) > 0) {
        int_max++;
    }

    while((int) (int_min-1) < 0) {
        int_min--;
    }

    while ((unsigned int) (unsigned_int + 1) > 0) 
    {
        unsigned_int++;
    }
    

    printf("Min char = %d\n", min_char);
    printf("Max char = %d\n", max_char);
    printf("Unsigned char = %d\n\n", unsigned_char);

    printf("Min short = %d\n", short_min);
    printf("Max short = %d\n", short_max);
    printf("Unsigned short = %d\n\n", unsigned_short);

    printf("Min int = %d\n", int_min);
    printf("Max int = %d\n", int_max);
    printf("Unsigned int = %d\n", unsigned_int);
}

int main() {
    limits();
    printf("-------------------------------------\n");
    limitsUsingLib();
    return 0;
}