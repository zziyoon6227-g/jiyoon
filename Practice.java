import java.util.Scanner;
public class Practice {
    public static void main(String[] args) {

        float[] arr = new float[6];
        Scanner sc = new Scanner(System.in);
    
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i + 1) + "번 학생 점수 입력: ");
            arr[i] = sc.nextFloat();
        }

        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        float average = sum / 6;
        System.out.println("\n===== [학급 성적 분석 결과] =====");
        System.out.printf("▶ 전체 합계: %.2f점\n", sum);
        System.out.printf("▶ 평균 점수: %.2f점\n", average);

        float max2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max2) {
                max2 = arr[i];
            }
        }
        System.out.printf("▶ 최고 점수: %.2f점\n", max2);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    float temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
       
        System.out.println("\n오름차순 정렬 결과:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}