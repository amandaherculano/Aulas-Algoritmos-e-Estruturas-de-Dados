// concentrar na execução da matemática

#include <studio.h>
#include <limits.h>

int fat( int n){
    int i, f;
    for (i=2, f=1; i <= n; i++)
        f *= i;
    return f;
}

int main (){
    printf("maior inteiro: %d\n", INT_MAX);
    for (int i = 1; i <= 13; i++)
        printf("fatorial de %d = %d\n", i , fat(i));
    return 0;
}