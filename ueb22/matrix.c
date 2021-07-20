#include <stdio.h>

#define X 2
#define Y 3

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

int find_max_in_col(int matrix[][Y], int colIndex) {
    if(colIndex >= Y) {
        return -1;
    }
    int max = matrix[0][colIndex];
    int i;
    for (i = 1; i < X; i++)
    {
        if (matrix[i][colIndex] > max)
        {
            max = matrix[i][colIndex];
        }

    }
    return max;
}

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
    int twoDimArr[2][3] = { { 1, 56, 2 }, { 7, 4, 9 } };
    int rowSize = sizeof twoDimArr / sizeof twoDimArr[0];

    print_matrix(twoDimArr, rowSize);
    int max = find_max_in_col(twoDimArr, 3);
    printf("%d", max);
}