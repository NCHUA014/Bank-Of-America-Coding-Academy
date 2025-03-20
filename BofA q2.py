#we should sort it in descending order.

bids1 = [
    [ 98, 5200 ],
    [ 99, 1000 ],
    [ 100, 1500 ],
    [ 101, 2000 ]
] #buy when the price is lower, he wants to buy as well. If higher, he doesnt want to buy

asks1 = [
    [ 99, 1000 ],
    [ 100, 2500 ],
    [ 101, 3000 ],
    [ 102, 2000 ]
]#sell. When price is higher, he also wants to sell even more.

bids2 = [
    [ 99, 1000 ],
    [ 98, 5200 ],
    [ 101, 2000 ],
    [ 100, 1500 ]
]
asks2 = [
    [ 102, 2000 ],
    [ 99, 1000 ],
    [ 100, 2500 ],
    [ 101, 3000 ],
]

bids3 = [
    [ 101, 500 ],
    [ 99, 1000 ],
    [ 98, 2200 ],
    [ 101, 1500 ],
    [ 100, 1500 ]
]
asks3 = [
    [ 102, 5000 ],
    [ 99, 1500 ],
    [ 100, 1000 ],
    [ 98.5, 2000 ],
    [ 99, 1500 ]
]



#bank wants to maximize profits. So we should check the price * quantity
#Quantity = lowest. We calculate this by checking the up or down, according to whether it is in bids.

def best_price(bids, asks):
    bids = bubble_sort(bids)
    asks = bubble_sort(asks)
    
    total = []
    price = []

    for rowb in range (len(bids)):
        quantityb = 0
        quantitya = 0

        for rowa in range (len(asks)):

            if bids[rowb][0] == asks[rowa][0]:
                price.append(bids[rowb][0])
                rowb1 = rowb
                rowa1 = rowa
                
                #for the buying side, we shall add all the upwards.
                while rowb1 < len(bids):
                    quantityb += bids[rowb1][1]
                    rowb1 += 1

                while rowa1 > 0:
                    quantitya += asks[rowa1][1]
                    rowa1 -= 1

                total.append(min(quantitya, quantityb)*price[-1] )

            else:
                continue

    index_of_max = total.index(max(total))
    print("The best price is", price[index_of_max], "with revenue", max(total))
    return price[index_of_max]

def bubble_sort(arr):
    n = len(arr)
    for i in range(n - 1):  # Number of passes
        swapped = False
        for j in range(n - 1 - i):  # Last `i` elements are already sorted
            if arr[j][0] > arr[j + 1][0]:  # Swap if out of order
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:  # If no swaps in a pass, array is sorted
            break

    return arr
    
best_price(bids1, asks1)
best_price(bids2, asks2)
best_price(bids3, asks3)








                
