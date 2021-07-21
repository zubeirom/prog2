#include <stdio.h>
#include <stdlib.h>

// Declare 2d array to nothing
int rowSize;
int colSize = 3;
int **twoDim;

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
        printf("\n");
    }
}
 
// Function that finds max in column
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

// Function that finds max in row
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

// Function that ask user to create a 2d array and return it.
void create_matrix() {
    printf("How many rows? ");
    scanf("%d", &rowSize);
    printf("How many columns? ");
    scanf("%d", &colSize);

    twoDim = (int **) malloc(rowSize * sizeof(int *));

    // Ask user to input values into 2d array
    int i, j;
    for (i = 0; i < rowSize; i++)
    {
        twoDim[i] = (int *) malloc(colSize * sizeof(int));
        for (j = 0; j < colSize; j++)
        {
            printf("Enter value at [%d][%d]: ", i, j);
            scanf("%d", &twoDim[i][j]);
        }
    }
}




int main()
{
    create_matrix();

    // Print the matrix
    print_matrix(twoDim, rowSize);

    // int max = find_max_in_col(twoDim, 2, rowSize);
    // printf("%d", max);
}