class Node
{
    constructor(value)
    {
        this.next=undefined;
        this.value=value;
    }
};

class List
{
    constructor()
    {
        this.head=undefined;
    }

    /* Determine whether the list is empty. */
    IsEmpty()
    {
        if( this.head === null){
            console.log("Wheres the node?")
        }
    }

    /* Insert a node with the given value to the end of the list */
    PushBack(value){
    var newNode = new Node(value);
    if (!this.head) {
        this.head = newNode;
    } else {
        var runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
    }
    return this.head;
}

    /* Insert an array of nodes with the given values to the end of the list. */
    PushBackN(arr) {
        for(let i = 0; i <arr.length; i++){
            this.PushBack(arr[i])
        }
        return this;
    }

    print(){
        let result = "";
        let runner = this.head;
        while(runner != null){
            result += `${runner.value} 👉 ⇶✨`; 
            runner = runner.next;
        }
        console.log(result.slice(0, result.length - 6));
    }

};

let test_data1=123;
let test_data2=234;
let test_data3=345;
let test_data4=[111,222,333,444,555];

/* Create our list */
let list=new List();
/* Insert nodes into the list: */
list.PushBack(test_data1);
list.PushBack(test_data2);
list.PushBack(test_data3);
list.PushBackN(test_data4);
list.print(list);