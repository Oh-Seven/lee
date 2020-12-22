package array;

/**
 *  SparseArray
 * @description 稀疏数组
 * @author lilei
 * @date 2020年12月17日 14:06:00
 * @version 1.0
 */
public class SparseArray {

    public static void main(String[] args) {
        //定义一个二维数组
        int[][] array = new int[11][11];
        array[1][5]=1;
        array[4][5]=2;
        for(int[] arr : array){
            for(int num : arr){
                System.out.printf("%d\t",num);
            }
            System.out.println();
        }
        int count = 1;
        for(int[] arr : array){
            for(int num : arr){
                if(num != 0){
                    count++;
                }
            }
        }
        //将其边变成稀疏数组
        System.out.println("稀疏数组如下:");

        //稀疏数组第一行保存原数组的行数，列数和有多少个值
        int[][] sparseArray = new int[count][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;
        int row = 0;
        for(int i =0;i<11;i++){
            for(int j =0;j<11;j++){
                if(array[i][j] != 0){
                    row++;
                    sparseArray[row][0] = i;//稀疏数组的第一个值 代表有值的原数组的行数
                    sparseArray[row][1] = j;//稀疏数组的第二个值 代表有值的原数组的列数
                    sparseArray[row][2] = array[i][j];//稀疏数组的第三个值 代表值
                }
            }
        }
        for(int[] arr : sparseArray){
            for(int num : arr){
                System.out.printf("%d\t",num);
            }
            System.out.println();
        }


        //将稀疏数组还原
        System.out.println("还原数组如下:");


        int[][] newArray = new int[11][11];

        for(int i =1;i<sparseArray.length;i++){
            newArray[sparseArray[i][0]][sparseArray[i][1]] =  sparseArray[i][2];
        }
        for(int[] arr : newArray){
            for(int num : arr){
                System.out.printf("%d\t",num);
            }
            System.out.println();
        }
    }
}
