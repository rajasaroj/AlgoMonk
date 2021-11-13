package algomonk.maximization.hungarian;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LLPHungarian {

    public static int counter = 0;
    public static void main(String[] args) {

        Integer[][] mainJobCard = {
                // Jobs
                {42, 35, 28, 21}, // 1
                {30, 25, 20, 15}, // 2
                {30, 25, 20, 15}, // 3
                {24, 20, 16, 12}  // 4
        };



        Integer[][] jobcard = {
                // Jobs
                {42, 35, 28, 21}, // 1
                {30, 25, 20, 15}, // 2
                {30, 25, 20, 15}, // 3
                {24, 20, 16, 12}  // 4
        };


        List<MetaData> column_indexes = new ArrayList<>();
        List<MetaData> row_indexes = new ArrayList<>();

        System.out.println("row reduction: ");
        rowRedux(jobcard);

        System.out.println("column reduction: ");
        columnRedux(jobcard);

        do {

            System.out.println("ITERATION: "+ counter++);
            column_indexes = rowSpan(jobcard);
            row_indexes = columnSpan(jobcard, column_indexes);
            while (!checkAllZerosCovered(jobcard, row_indexes, column_indexes)) {
                // Do Nothing
            }

            if ((row_indexes.size() + column_indexes.size()) == jobcard.length) {
                break;
            }

            reconcile(jobcard, row_indexes, column_indexes);
            System.out.println(column_indexes);
            System.out.println(row_indexes);

        } while ((row_indexes.size() + column_indexes.size()) != jobcard.length);




        System.out.println("Final Matrix");
        for (int i = 0; i < jobcard.length; i++) {
            System.out.println(Arrays.toString(jobcard[i]));
        }



        int total_cost = 0;
        List<Integer> optimalPath = new ArrayList<>();

        for (MetaData e: row_indexes) {
            total_cost += mainJobCard[e.location.i][e.location.j];
            optimalPath.add(mainJobCard[e.location.i][e.location.j]);
        }

        for (MetaData e: column_indexes) {
            total_cost += mainJobCard[e.location.i][e.location.j];
            optimalPath.add(mainJobCard[e.location.i][e.location.j]);
        }
        System.out.println("Total Cost: "+ total_cost);

        System.out.println("Optimal Path");
        for (int i = 0; i < mainJobCard.length; i++) {
            System.out.println("Job "+ (i+1) + " : "+ optimalPath.get(i));
        }

        System.out.println(column_indexes);
        System.out.println(row_indexes);

    }

    public static void rowRedux(Integer[][] jobcard) {

        // row Redux
        for (int i = 0; i < jobcard.length; i++) {
            int min = Arrays.stream(jobcard[i]).mapToInt(v -> v).min().getAsInt();
            for (int j = 0; j < jobcard[i].length; j++) {
                jobcard[i][j] = jobcard[i][j] - min;
            }
            System.out.println(Arrays.toString(jobcard[i]));
        }
    }

    public static void columnRedux(Integer[][] jobcard) {

        int[] min_array = new int[jobcard.length];
        int min = jobcard[0][0];

        // Extract min from columns
        for (int i = 0; i < jobcard.length; i++) {
            for (int j = 0; j < jobcard[i].length; j++) {
                if(jobcard[j][i] < min) min = jobcard[j][i];
            }
            min_array[i] = min;
        }


        // Column Redux
        for (int i = 0; i < jobcard.length; i++) {
            for (int j = 0; j < jobcard[i].length; j++) {
                jobcard[j][i] = jobcard[j][i] - min_array[i];
            }

        }

        // Print
        for (int i = 0; i < jobcard.length; i++) {
            System.out.println(Arrays.toString(jobcard[i]));
        }

    }

    public static List<MetaData> rowSpan(Integer[][] jobcard) {

        List<MetaData> column_index = new ArrayList<>();

        for (int i = 0; i < jobcard.length; i++) {
            boolean shouldAdd = false;
            for (int j = 0; j < jobcard.length; j++) {
                if ( !column_index.contains(new MetaData(j)) && jobcard[i][j] == 0) {
                    shouldAdd  = !shouldAdd;
                    if ((shouldAdd)) {
                        column_index.add(new MetaData(j, false, new MetaData.Location(i,j)));
                    } else {
                        column_index.remove(column_index.size() - 1);
                        break;
                    }
                }
            }
        }

        System.out.println("column indexes");
        System.out.println(column_index);
        return column_index;
    }

    public static List<MetaData> columnSpan(Integer[][] jobcard, List<MetaData> column_index) {

        List<MetaData> row_index = new ArrayList<>();

        for (int i = 0; i < jobcard.length; i++) {
            boolean shouldAdd = false;
            if (column_index.contains(new MetaData(i))) continue;

            for (int j = 0; j < jobcard.length; j++) {
                if ( !row_index.contains(new MetaData(j)) && jobcard[j][i] == 0) {
                    shouldAdd  = !shouldAdd;
                    if ((shouldAdd)) {
                        row_index.add(new MetaData(j, true, new MetaData.Location(j,i)));
                    } else {
                        row_index.remove(row_index.size() - 1);
                        break;
                    }
                }
            }
        }

        System.out.println("row indexes");
        System.out.println(row_index);
        return row_index;
    }

    public static List<Pair<Integer, Integer>> findIntersection(List<MetaData> row_indexes, List<MetaData> column_indexes) {

        return row_indexes.stream().flatMap(row_striked -> column_indexes.stream().map(column_striked -> new Pair<>(row_striked.location.i, column_striked.location.j)))
                .collect(Collectors.toList());
    }

    public static boolean checkAllZerosCovered(Integer[][] jobcard,  List<MetaData> row_indexes, List<MetaData> column_indexes) {

        boolean isCovered = false;
        for (int i = 0; i < jobcard.length; i++) {
            for (int j = 0; j < jobcard.length; j++) {

                if (jobcard[i][j] != 0) continue;
                isCovered = scanZeros(row_indexes, column_indexes, false, i, j);

                if (!isCovered) {
                    isCovered = scanZeros(row_indexes, column_indexes, false, i+1, j+1);

                    if(!isCovered && jobcard[i+1][j+1] == 0) {
                        column_indexes.add(new MetaData(j, false, new MetaData.Location(i, j)));
                        column_indexes.add(new MetaData(j+1, false, new MetaData.Location(i+1, j+1)));
                    } else {
                        System.out.println("algo crashed while achieving optimality :(");
                    }
                    return false;
                }
            }
        }

        return isCovered;
    }

    public static boolean scanZeros(List<MetaData> row_indexes, List<MetaData> column_indexes, boolean isCovered, int i, int j) {
        for (MetaData e: column_indexes) {
            if (e.location.j == j) {
                isCovered = true;
            }
        }

        for (MetaData e: row_indexes) {
            if ( e.location.i == i) {
                isCovered = true;
            }
        }

        if (!isCovered) {
            return false;
        }

        return isCovered;
    }

    public static int getMinFromReduxMatrix(Integer[][] jobcard, List<MetaData> row_indexes, List<MetaData> column_indexes) {

        boolean isStriked = false;
        int min = jobcard[0][0];
        for (int i = 0; i < jobcard.length; i++) {
            for (int j = 0; j < jobcard.length; j++) {
                isStriked = scanZeros(row_indexes, column_indexes, false, i,j);
                if(!isStriked && jobcard[i][j] < min) {
                    min = jobcard[i][j];
                }
            }
        }
        System.out.println("minimum value in the whole matrix : "+ min);
        return min;
    }

    public static void reconcile(Integer[][] jobcard, List<MetaData> row_indexes, List<MetaData> column_indexes) {

        int min = getMinFromReduxMatrix(jobcard, row_indexes, column_indexes);
        List<Pair<Integer, Integer>> intersections = findIntersection(row_indexes, column_indexes);

        intersections.forEach(x -> {
            int i = x.getKey();
            int j = x.getValue();
            jobcard[i][j] =jobcard[i][j]+min;
        });

        System.out.println("Redux Matrix after subtracting with minimum");
        for (int i = 0; i < jobcard.length; i++) {
            for (int j = 0; j < jobcard.length; j++) {
                if(!scanZeros(row_indexes, column_indexes, false, i,j)) {
                    jobcard[i][j] = jobcard[i][j] - min;
                }
            }
            System.out.println(Arrays.toString(jobcard[i]));
        }
    }
}

class MetaData {

    static class Location {
        int i,j;

        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
    int index;
    boolean isRowStriked;
    Location location;

    public MetaData(int index) {
        this.index = index;
    }

    public MetaData(int j_col, boolean isRowStriked, Location location) {
        this.index = j_col;
        this.isRowStriked = isRowStriked;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaData metaData = (MetaData) o;
        return index == metaData.index;
    }

    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "index=" + index +
                ", isRowStriked=" + isRowStriked +
                ", location=" + location +
                '}';
    }
}


