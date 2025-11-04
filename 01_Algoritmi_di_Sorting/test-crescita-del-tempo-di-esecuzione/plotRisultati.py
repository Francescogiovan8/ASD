import pandas as pd
import matplotlib.pyplot as plt

csv1 = pd.read_csv('TempiBubbleSort.csv', sep=';', decimal=',', header=None)
csv2 = pd.read_csv('TempiInsertionSort.csv', sep=';', decimal=',', header=None)
csv3 = pd.read_csv('TempiMergeSort.csv', sep=';', decimal=',', header=None)  # correggi il file se diverso

x1, y1 = csv1[0], csv1[1]
x2, y2 = csv2[0], csv2[1]
x3, y3 = csv3[0], csv3[1]

plt.figure(figsize=(10,6))

plt.plot(x1, y1, label='BubbleSort', color='blue', marker='o')
plt.plot(x2, y2, label='InsertionSort', color='red', marker='s')
plt.plot(x3, y3, label='MergeSort', color='green', marker='^')

plt.title('Confronto tempi algoritmi di ordinamento')
plt.xlabel('Dimensione input')
plt.ylabel('Tempo di esecuzione (s)')
plt.legend()
plt.grid(True)

plt.tight_layout()
plt.savefig('grafico.png', dpi=300)
print("Grafico salvato come grafico.png")
