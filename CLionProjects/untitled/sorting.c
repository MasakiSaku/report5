#include <stdio.h>

void print (int array[],int size){
    /*結果を表示する*/

    for(int i=0; i<size; i++){

        printf("%d ",array[i]);

    }
}

void sort(int array[], int size){
    /*
     * ソートアルゴリズムを利用して、並び替える。
     *
     *　引数：　配列リスト、配列のサイズ
     */

    for (int i=0; i<size; i++ ){
        int j = size -1;

        for(int k=j-1; k >= i; k--){

            if(array[k]<array[j]){
                int chan_num = array[j];

                array[j] = array[k];
                array[k] = chan_num;
                j--;

            }else{
                j--;

            }
        }
    }
    //並び替えた結果を表示する
    print (array,size);
    printf("\n");
}

 int main() {
     const int SIZE = 6; //定数として配列のサイズを宣言
     int scores[SIZE] = {100, 60, 70, 100, 90,80};

     printf("scores = ");
     print(scores,SIZE);

     printf("\nresult = ");
     sort(scores,SIZE);

    return 0;

}