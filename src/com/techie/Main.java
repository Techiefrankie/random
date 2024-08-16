package com.techie;

import java.util.*;

public class Main {
    // using memoization to improve the fibonacci algorithm
    private  static Map<Integer, Long> fibCache = new HashMap<>();
    public static void main(String[] args) {
	    System.out.println("Here we come!");

        String[][] trainNetwork = new String[][] {
                {"city1", "city2"},
                {"city1", "city3"},
                {"city2", "city3"},
                {"city3", "city4"},
                {"city2", "city5"},
        };

        System.out.println("Train routes: " + findTrainNetworks(trainNetwork, "city1", "city2"));

        // get maximum student's grade
        String[][] grades = {
                {"Rachel", "100"},
                {"Phoebe", "80"},
                {"Monica", "95"},
                {"Rachel", "50"},
                {"Phoebe", "60"}
        };
        System.out.println("Maximum Average: " + findMaximumAverage(grades));
        System.out.println("Maximum Average: " + findMaxAvg(grades));
        System.out.println("Maximum Average 2: " + getMaxAverage2(grades));

        // sort intervals
        int[][] intervals = new int[][] {
                {5,7},
                {15,29},
                {1,5},
                {12,15},
                {29,34},
                {9,12},
                {7,9}
        };

        sortIntervals2(intervals);

	    int[] arr1 = {0,2,3,4,5};
	    int[] arr2 = {1,7,3,2,0,5,9,7,6,8};

        // check for array unique frequencies
        boolean isUnique1 = hasUniqueFrequencies(arr1);
        boolean isUnique2 = hasUniqueFrequencies(new int[] {1,2,2,3,3,3,4,4,4,4});

        // check for pivot index
        int[] pivotArray = new int[] {1,2,3,4,5,3,2,1};
        int[] pivotArray2 = new int[] {1,2,3,4,5,6,7,8,9,0};
        int[] pivotArray3 = new int[] {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot index is: " + getPivotIndex(pivotArray3));

        // Arrange course in order to be taken, first course is the main, second is the prerequisite
        String[][] courses = new String[][] {
                {"CMS311", "CMS211"},
                {"CMS411", "CMS311"},
                {"CMS211", "CMS111"},
        };

        String[][] orderedCourses = getCourseOrder(courses);
        for (String[] course : orderedCourses) {
            System.out.println(Arrays.toString(course));
        }

        System.out.println(findFirstNonRepeatingCharacter2("sums".toCharArray()));
        System.out.println("First non repeating character: sums => " +findFirstNonRepeatingCharacter("sums".toCharArray()));

        System.out.println("Units of snow: " + countSnowUnits(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));

        int k = 3; // Example value for N
        List<String> combinations = generateParentheses(k);
        System.out.println("Possible combinations: ");
        for (String combination : combinations) {
            System.out.println(combination);
        }

	    System.out.println(Arrays.toString(arr1) + " is a subset of " + Arrays.toString(arr2) + ": " + isSubset(arr1, arr2));

	    System.out.println("Selection Sort: " + Arrays.toString(selectionSort(new int[]{8, 1, 2, 3, 4, 5, 6, 7, 9})));

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int sum = 280;
        int n = 5;
        System.out.printf("\n%s has %d combinations that sums up to %d = %s", Arrays.toString(arr), n, sum, hasCombination(arr, sum, n));

        int nth = 600;;

        System.out.println("\nStarted at: " + new Date());
        //System.out.printf("The %dth fibonacci series is %d", nth, fib(nth));
        for (int i = 0; i <= nth; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println("\nEnded at: " + new Date());
    }

    private  static  boolean isSubset(int[] arrx, int[]arry){
        for (int index : arrx){
            if (!isInArray(index, arry))
                return  false;
        }
        return true;
    }

    private  static  boolean isInArray(int element, int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == element)
                return true;
        }
        return false;
    }

    private static int[] sortArray(int[] array){
        int[] sorted = new int[array.length];
        for (int i = 0; i < array.length; i++){
            sorted[i] = returnLesser(array[i], array);
        }

        return sorted;
    }

    private static  int returnLesser(int index, int[] array){
        for (int element : array){
            if (element < index)
                return element;
        }
        return  index;
    }

    private  static int binSearch (int element, int[] array, int low, int high){
       if (high >= low) {
           int mid = (low + high) / 2;

           if (element == mid)
               return mid;
           if (element < mid)
               return binSearch(element,array, low, mid - 1);
           if (element > mid)
               return binSearch(element,array, mid + 1, high);
       }
        return  -1;
    }

    private static int[] selectionSort(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size - 1; i++){

            int minIndex = 0;
            for (int j = i + 1; j < size; j ++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return  arr;
    }

    public static boolean hasCombination(int[] arr, int sum, int n) {
        return hasCombination(arr, sum, 0, n);
    }

    public static boolean hasCombination(int[] arr, int sum, int startIndex, int n) {
        if (n == 0) {
            return sum == 0;
        }

        for (int i = startIndex; i < arr.length; i++) {
            if (hasCombination(arr, sum - arr[i], i + 1, n-1)) {
                return true;
            }
        }

        return false;
    }

    public static long fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }

        long fibN = fib(n - 1) + fib(n - 2);
        fibCache.put(n, fibN);

        return fibN;
    }

    /***
     *
     * @param grades A 2D array of students and their grades
     * @return An integer which the maximum of the averages of the students scores
     */
    public static int getMaxAverage(String[][] grades) {
        Map<String, List<Integer>> studentScore = new HashMap<>();

        // collect a list students with their respect grades
        for (String[] grade : grades) {
            String student = grade[0];
            int score = Integer.parseInt(grade[1]);

            if (studentScore.containsKey(student)) {
                // If the student already has a list of grades, add the new grade
                studentScore.get(student).add(score);
            } else {
                // First instance of adding grade
                List<Integer> scores = new ArrayList<>();
                scores.add(score);
                studentScore.put(student, scores);
            }
        }

        // compute the average garde
        List<Integer> averages = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> scores : studentScore.entrySet()) {
            // compute the average grade by summing grades and dividing  by n-scores
            int average = scores.getValue().stream().mapToInt(Integer::intValue).sum() / scores.getValue().size();
            averages.add(average);
        }

        // return the maximum of the averages
        return Collections.max(averages);
    }

    public static double getMaxAverage2(String[][] grades) {
        Map<String, int[]> scores = new HashMap<>();

        // collect all the students and their respective scores
        for (String[] grade : grades) {
            String student = grade[0];
            int score = Integer.parseInt(grade[1]);

            int[] previousRecord = scores.getOrDefault(student, new int[2]);
            previousRecord[0] = previousRecord[0] + score;
            previousRecord[1] = previousRecord[1] + 1;

            scores.putIfAbsent(student, previousRecord);
        }

        double maxAvg = 0;

        for (Map.Entry<String, int[]> score : scores.entrySet()) {
            int[] grade = score.getValue();
            double avg = (double) grade[0] / grade[1];

            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        return maxAvg;
    }

    /***
     * Utilizes constant time space complexity to solve the problem.
     * @param grades A 2D array of students and their grades
     * @return An integer which the maximum of the averages of the students scores
     */
    public static double findMaximumAverage(String[][] grades) {
        // Variables to keep track of cumulative scores and counts for each student
        double maxAverage = Double.NEGATIVE_INFINITY;

        // Traverse through the array to compute scores and counts
        for (int i = 0; i < grades.length; i++) {
            String student = grades[i][0];
            double totalScore = 0;
            int count = 0;

            // Calculate the cumulative score and count for the current student
            for (int j = 0; j < grades.length; j++) {
                if (grades[j][0].equals(student)) {
                    totalScore += Double.parseDouble(grades[j][1]);
                    count++;
                }
            }

            // Calculate the average score for the current student
            double averageScore = totalScore / count;

            // Update maxAverage if the current average score is higher
            if (averageScore > maxAverage) {
                maxAverage = averageScore;
            }
        }

        return maxAverage;
    }

    /***
     *
     * @param intervals A 2D array to be sorted
     * @return A sorted 2D array
     */
    private static int[][] sortIntervals(int[][] intervals) {
        List<Integer> startPoint = new ArrayList<>();
        List<Integer> endPoints = new ArrayList<>();

        // build a list of the respective start and end points of all the intervals
        for (int[] interval : intervals) {
            startPoint.add(interval[0]);
            endPoints.add(interval[1]);
        }

        // sort the lists
        Collections.sort(startPoint);
        Collections.sort(endPoints);

        // collate the intervals
        int[][] result = new int[startPoint.size()][endPoints.size()];

        for (int i = 0; i < startPoint.size(); i++) {
            int[] interval = new int[] {startPoint.get(i), endPoints.get(i)};
            result[i] = interval;
        }

        // display the result
        return result;
    }

    /***
     *
     * @param intervals A 2D array to be sorted
     * @return A sorted 2D array
     */
    private static int[][] sortIntervals2(int[][] intervals) {
        int[][] result = new int[intervals.length][intervals.length];


        // read the intervals into a hashmap and keep track of the starting points
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> startPoints = new ArrayList<>();

        for (int[] interval : intervals) {
            map.put(interval[0], interval[1]);
            startPoints.add(interval[0]);
        }

        // traverse the map from the start point down to the last
        int index = Collections.min(startPoints);
        int counter = 0;

        for (int ignored : startPoints) {
            int nextStart = map.get(index);
            result[counter++] = new int[] {index, nextStart};

            // update the next starting point and counter
            index = nextStart;
        }

        return result;
    }

    /***
     *
     * @param arr An array of integer
     * @return true if the array contains unique frequencies for each item of the array
     */
    private static boolean hasUniqueFrequencies(int[] arr) {
        List<Long> frequencies = new ArrayList<>();
        Set<Integer> nums = new HashSet<>();

        for (int num : arr) {
            long freq = Arrays.stream(arr).filter(n -> n == num).count();

            if (!nums.contains(num)) {
                frequencies.add(freq);
            }

            nums.add(num);
        }

        // check for uniqueness of frequencies
        for (long freq : frequencies) {
            long freqCount = frequencies.stream()
                    .filter(f -> f == freq)
                    .count();

            if (freqCount > 1) return false;
        }

        return true;
    }

    /***
     * Return the index such that the sum of elements to the left and right of it are equal
     * if there are two of such, return the leftmost index, if none return -1
     * @param arr An array to be processed
     * @return An integer A the above logic
     */
    public static int getPivotIndex(int[] arr) {
        int leftSum = 0;
        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

       for (int i = 0; i < arr.length; i++) {
           int rightSum = totalSum - leftSum - arr[i];

           if (leftSum == rightSum)
               return i;
           leftSum += arr[i];
       }
        return -1;
    }

    /***
     * Given a 2D array containing main courses and their prerequisite courses,
     * output the courses in the order they should be taken according to their prerequisites
     * @param courses: 2D array of unordered courses
     * @return 2D array of the ordered courses
     */
    public static String[][] getCourseOrder(String[][] courses) {
        // organize all the prerequisite and main courses in a map using the prerequisites as key and main courses
        // as the values

        Map<String, String> courseMap = new HashMap<>();
        Set<String> mainCourses = new LinkedHashSet<>();

        for (String[] course : courses) {
            String pre = course[1];
            String main = course[0];

            courseMap.put(pre, main);
            mainCourses.add(main);
        }

        // get the first course
        String entryCourse = "";
        for (Map.Entry<String, String> co : courseMap.entrySet()) {
            String pre = co.getKey();
            if (!mainCourses.contains(pre)) {
                entryCourse = pre;
            }
        }

        String[][] orderedCourses = new String[courses.length][courses.length];

        int index = 0;
        for (String ignored : mainCourses) {
            String mainCourse = courseMap.get(entryCourse);
            orderedCourses[index++] = new String[] {entryCourse, mainCourse};

            // update next prerequisite course
            entryCourse = mainCourse;
        }

        return orderedCourses;
    }

    public static char findFirstNonRepeatingCharacter(char[] arr) {
        String str = new String(arr);

        Map<Character, Integer> counts = new HashMap<>();

        // count the occurrences
        for (int i = 0; i < str.length(); i++) {
            counts.put(str.charAt(i), counts.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> count : counts.entrySet()) {
            if (count.getValue() == 1) {
                return count.getKey();
            }
        }

        return ' ';
    }

    public static char findFirstNonRepeatingCharacter2(char[] arr) {
        String boxed = new String(arr);
        String[] newArr = boxed.split("");

        for (String ch : newArr) {
            long numOccurrence = Arrays.stream(newArr).filter(c -> c.equals(ch)).count();
            if (numOccurrence == 1) {
                return ch.charAt(0);
            }
        }

        return ' ';
    }

    /***
     * Given an array of non-negative integers representing the elevations from the vertical cross-section of a range of hills,
     * determine how many units of snow could be captured between the hills.
     * @param heights representing the heights of the hills
     * @return int, the unit of the trapped snow
     */
    public static int countSnowUnits(int[] heights) {
        int left = 0, right = heights.length - 1;
        int leftMax = 0, rightMax = 0;
        int snowUnits = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    snowUnits += leftMax - heights[left];
                }
                left++;
            } else {
                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    snowUnits += rightMax - heights[right];
                }
                right--;
            }
        }

        return snowUnits;
    }

    // Function to find the maximum sum
// path in the grid
    static int MaximumPath(int [][]grid)
    {
        // Dimensions of grid[][]
        int N = grid.length;
        int M = grid[0].length;

        // Stores maximum sum at each cell
        // sum[i][j] from cell sum[0][0]
        int [][]sum = new int[N + 1][M + 1];

        // Iterate to compute the maximum
        // sum path in the grid
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                // Update the maximum path sum
                sum[i][j] = Math.max(sum[i - 1][j],
                        sum[i][j - 1]) +
                        grid[i - 1][j - 1];
            }
        }

        // Return the maximum sum
        return sum[N][M];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // add up arrays
        int[] joined = Arrays.copyOf(nums1, nums1.length + nums2.length);
        Arrays.sort(joined);

        int mid;
        if (joined.length % 2 == 0) {
            mid = joined[joined.length / 2];
        } else {
            int index = joined.length / 2;
            mid = (joined[index] + joined[index + 1]) / 2;
        }

        return mid;
    }

    static double findMaxAvg(String[][] grade) {
        double maxAvg = 0;

        for (int i = 0; i < grade.length; i++) {
            String student = grade[i][0];
            int score = Integer.parseInt(grade[i][1]);

            int totalScore = 0;
            int count = 0;

            for (int j = 0; j < grade.length; j++) {
                String nextStudent = grade[j][0];
                if (student.equals(nextStudent)) {
                    int nextScore = Integer.parseInt(grade[j][1]);
                    totalScore += nextScore;
                    count++;
                }
            }

            double avg = totalScore/count;

            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        return maxAvg;
    }

    /***
     * You're given a positive integer N which denotes the number of pair of parenthesis
     * ("()" is a pair). The task is to determine the combinations of well-formed balanced parenthesis.
     * For example (())() is a well formed parenthesis but (() is not.
     * @param n
     * @return
     */
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesRecursive(result, "", 0, 0, n);
        return result;
    }

    private static void generateParenthesesRecursive(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generateParenthesesRecursive(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            generateParenthesesRecursive(result, current + ")", open, close + 1, max);
        }
    }

    /***
     * Given a multi-dimension array of cities showing a train's network
     * [
     * ["city1": "city2"],
     * ["city1": "city3"],
     * ["city2": "city3"],
     * ["city3": "city4"],
     * ["city2": "city5"],
     * ]
     * Given a source and target city, return the trains route.
     */
    private static String findTrainNetworks(String[][] trainNetwork, String city1, String city2) {
        Map<String, List<String>> routes = new HashMap<>();

        for (String[] network : trainNetwork) {
            // if entry exists
            if (routes.containsKey(network[0])) {
                List<String> list = routes.get(network[0]);
                list.add(network[1]);
            } else {
                // new entry
                List<String> newList = new ArrayList<>();
                newList.add(network[1]);
                routes.put(network[0], newList);
            }
        }

        if (!routes.containsKey(city1) && !routes.containsKey(city2)) {
            return "";
        }

        List<String> city1Routes = routes.get(city1);
        List<String> city2Routes = routes.get(city2);

        // merge both routes
        city1Routes.addAll(city2Routes);

        StringBuilder sb = new StringBuilder();

        if (!city1Routes.contains(city1)) {
            sb.append(city1).append(",");
        }
        if (!city1Routes.contains(city2)) {
            sb.append(city2).append(",");
        }

        Set<String> result = new HashSet<>(city1Routes);

        for (String route : result) {
            sb.append(route).append(",");
        }

        return sb.toString();
    }
}
