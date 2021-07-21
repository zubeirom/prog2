#include <stdio.h>
#include <stdlib.h>

// Declare 2d array to nothing
int twoDim;
int rowSize;
int colSize = 3;

// Function that takes a 2d array and prints it out.
void print_matrix(int matrix[][colSize], int rowSize)
{
    int i, j;
    for (i = 0; i < rowSize; i++)
    {
        printf("|");
        for (j = 0; j < colSize; j++)
        {
            printf(" %d ", matrix[i][j]);
        }
        printf("|");
        printf("\n");
    }
}

int find_max_in_col(int matrix[][colSize], int colIndex, int rowSize) {
    if(colIndex >= colSize) {
        return -1;
    }
    int max = matrix[0][colIndex];
    int i;
    for (i = 1; i < rowSize; i++)
    {
        if (matrix[i][colIndex] > max)
        {
            max = matrix[i][colIndex];
        }

    }
    return max;
}

int find_max_in_row(int matrix[][colSize], int rowIndex)
{
    int max = 0;
    int j;
    for (j = 0; j < colSize; j++)
    {
        if (matrix[rowIndex][j] > max)
        {
            max = matrix[rowIndex][j];
        }
    }
    return max;
}


// Dialog to create matrix

int main()
{
    create_matrix();
    // Print the matrix
    print_matrix(twoDim, rowSize);

    // int max = find_max_in_col(twoDim, 2, rowSize);
    // printf("%d", max);
}