from random import randrange
a = [7,2,4,5,1,3,9,8,5,8]
#a=[9,4,34,29,54,19,3,7,12]
def reorder(l,r,array):
    x = randrange(l,r)
    pivot = array[x]
    while(l<r):
        while(array[l]<pivot):
            l=l+1
        while(array[r]>pivot):
            r=r-1
        if(l<r and array[r]!=array[l]):
            array[l],array[r]=array[r],array[l]       
        else:
            return l
def quicksort(array,l,r):
    if(l<r):
        #print(l,r)
        q = reorder(l,r,array)
        if q>0:
            quicksort(array,l,q-1)
        if q<len(a)-1:
            quicksort(array,q+1,r)
    
quicksort(a,0,len(a)-1)
print(a)
    
            
    