#include <stdio.h>

int Y = 3;

// Function that takes a 2d array and prints it out.
void print_matrix(int matrix[][Y], int rowSize)
{
    int i, j;
    for (i = 0; i < rowSize; i++)
    {
        printf("|");
        for (j = 0; j < Y; j++)
        {
            printf(" %d ", matrix[i][j]);
        }
        printf("|");
        printf("\n");
    }
}

// Function that finds max in column.
int find_max_in_col(int matrix[][Y], int colIndex, int rowSize) {
    if(colIndex >= Y) {
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

// Function that finds max in row.
int find_max_in_row(int matrix[][Y], int rowIndex)
{
    int max = 0;
    int j;
    for (j = 0; j < Y; j++)
    {
        if (matrix[rowIndex][j] > max)
        {
            max = matrix[rowIndex][j];
        }
    }
    return max;
}

int main()
{
    int twoDimArr[2][5] = { { 1, 56, 2, 5, 9 }, { 7, 4, 9, 5, 3 } };
    int rowSize = sizeof twoDimArr / sizeof twoDimArr[0];
    int colSize = sizeof twoDimArr[0] / sizeof twoDimArr[0][0];

    Y = colSize;
    print_matrix(twoDimArr, rowSize);
    int max = find_max_in_col(twoDimArr, 2, rowSize);
    printf("%d", max);
}