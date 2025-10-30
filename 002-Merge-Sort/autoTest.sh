#!/bin/bash

# File CSV di output
output_file="tempi.csv"
> "$output_file"

# Ciclo da 1 a 1.000.000
for ((i=1; i<=1000; i++)); do
    echo "▶️  Eseguo con n = $i"

    # Cattura solo il tempo reale in secondi
    real_time=$( ( time java MergeSort "$i" ) 2>&1 | grep real | awk '{print $2}' | sed 's/[^0-9.]//g')

    # Salva n e tempo in CSV
    echo "$i,$real_time" >> "$output_file"

    # (opzionale) stampa il tempo su schermo
    echo "$real_time"
done

echo "🏁 Tutte le esecuzioni completate. Tempi salvati in $output_file"
