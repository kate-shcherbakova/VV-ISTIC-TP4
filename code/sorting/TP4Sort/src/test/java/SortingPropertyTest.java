import net.jqwik.api.*;
import org.example.Sorting;

import java.util.*;

import org.assertj.core.api.Assertions;

class SortingPropertyTest {

    @Property
    void testBubbleSort(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Integer[] originalArray = originalList.toArray(new Integer[0]);
        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(bubbleSorted).containsExactlyElementsOf(originalList);
    }

    @Property
    void testQuickSort(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Integer[] originalArray = originalList.toArray(new Integer[0]);
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(quickSorted).containsExactlyElementsOf(originalList);
    }

    @Property
    void testMergeSort(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Integer[] originalArray = originalList.toArray(new Integer[0]);
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(mergeSorted).containsExactlyElementsOf(originalList);
    }

    @Example
    void testEmptyListSorting() {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(new Integer[0], Comparator.naturalOrder())));
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(new Integer[0], Comparator.naturalOrder())));
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(new Integer[0], Comparator.naturalOrder())));

        Assertions.assertThat(bubbleSorted).isEmpty();
        Assertions.assertThat(quickSorted).isEmpty();
        Assertions.assertThat(mergeSorted).isEmpty();
    }
    @Property
    void testSortingAlgorithms(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Integer[] originalArray = originalList.toArray(new Integer[0]);

        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(bubbleSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(quickSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(mergeSorted).containsExactlyElementsOf(originalList);
    }
    @Property
    void testAlreadySortedArray(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Collections.sort(originalList);

        Integer[] originalArray = originalList.toArray(new Integer[0]);

        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(originalArray.clone(), Comparator.naturalOrder())));

        Assertions.assertThat(bubbleSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(quickSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(mergeSorted).containsExactlyElementsOf(originalList);
    }

    @Property
    void testReverseSortedArray(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Collections.sort(originalList, Comparator.reverseOrder());

        Integer[] originalArray = originalList.toArray(new Integer[0]);

        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(bubbleSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(quickSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(mergeSorted).containsExactlyElementsOf(originalList);
    }

    @Property
    void testDuplicateValues(
            @ForAll("intLists") List<Integer> originalList
    ) {
        originalList.addAll(originalList);

        Integer[] originalArray = originalList.toArray(new Integer[0]);

        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(bubbleSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(quickSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(mergeSorted).containsExactlyElementsOf(originalList);
    }

    @Property
    void testRandomOrderArray(
            @ForAll("intLists") List<Integer> originalList
    ) {
        Collections.shuffle(originalList);

        Integer[] originalArray = originalList.toArray(new Integer[0]);

        List<Integer> bubbleSorted = new ArrayList<>(Arrays.asList(Sorting.bubblesort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> quickSorted = new ArrayList<>(Arrays.asList(Sorting.quicksort(originalArray.clone(), Comparator.naturalOrder())));
        List<Integer> mergeSorted = new ArrayList<>(Arrays.asList(Sorting.mergesort(originalArray.clone(), Comparator.naturalOrder())));

        Collections.sort(originalList);

        Assertions.assertThat(bubbleSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(quickSorted).containsExactlyElementsOf(originalList);
        Assertions.assertThat(mergeSorted).containsExactlyElementsOf(originalList);
    }
    @Provide
    Arbitrary<List<Integer>> intLists() {
        return Arbitraries.integers().list().ofMinSize(5).ofMaxSize(20)
                .injectDuplicates(0.2)
                .map(list -> {
                    List<Integer> sortedList = new ArrayList<>(list);
                    Collections.sort(sortedList);
                    return sortedList;
                });
    }
}
