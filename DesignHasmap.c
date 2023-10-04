typedef struct {
    int table[1000001];
} MyHashMap;


MyHashMap* myHashMapCreate() {
    MyHashMap* X=(MyHashMap*)malloc(sizeof(MyHashMap));
    memset(X->table, -1, sizeof(X->table));
    return X;
}

void myHashMapPut(MyHashMap* X, int key, int value) {
    X->table[key]=value;
}

int myHashMapGet(MyHashMap* X, int key) {
    return X->table[key]==-1?-1:X->table[key];
}

void myHashMapRemove(MyHashMap* X, int key) {
    X->table[key]=-1;
}

void myHashMapFree(MyHashMap* X) {
    free(X);
}
