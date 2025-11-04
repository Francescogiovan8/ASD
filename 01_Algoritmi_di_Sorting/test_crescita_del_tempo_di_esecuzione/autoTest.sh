#!/bin/bash

output_file_InsertionSort="TempiInsertionSort.csv"
output_file_MergeSort="TempiMergeSort.csv"
output_file_BubbleSort="TempiBubbleSort.csv"
> "$output_file_InsertionSort"
> "$output_file_MergeSort"
> "$output_file_BubbleSort"

progressione=1000
tot=100000

# Ciclo da 0 a tot

echo "INIZIO Insertion Sort"
for ((i=0; i<=$tot; i=i+$progressione)); do
    #echo "▶️  Eseguo Insertion Sort con n = $i"

    real_time=$(
        { time java -cp ../001_Insertion_Sort InsertionSort "$i"; } 2>&1 \
        | awk '/real/ {
            split($2, a, "m");
            sec = a[1]*60 + a[2];
            printf "%.6f", sec
        }'
    )
    
    echo "$i;$real_time" >> "$output_file_InsertionSort"

    #echo "$real_time"
done

echo "INIZIO Merge Sort"
for ((i=0; i<=$tot; i=i+$progressione)); do
    #echo "▶️  Eseguo Merge Sort con n = $i"

    real_time=$(
        { time java -cp ../002_Merge_Sort MergeSort "$i"; } 2>&1 \
        | awk '/real/ {
            split($2, a, "m");
            sec = a[1]*60 + a[2];
            printf "%.6f", sec
        }'
    )

    echo "$i;$real_time" >> "$output_file_MergeSort"

    #echo "$real_time"
done

echo "INIZIO Bubble Sort"
for ((i=0; i<=$tot; i=i+$progressione)); do
    #echo "▶️  Eseguo Bubble Sort con n = $i"

    real_time=$(
        { time java -cp ../003_Bubble_Sort BubbleSort "$i"; } 2>&1 \
        | awk '/real/ {
            split($2, a, "m");
            sec = a[1]*60 + a[2];
            printf "%.6f", sec
        }'
    )

    echo "$i;$real_time" >> "$output_file_BubbleSort"

    #echo "$real_time"
done

echo "🏁 Tutte le esecuzioni completate."
