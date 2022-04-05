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


    insertAtFront(data) {
        if (!this.head) {
            return -1;
        }
        let temp = new Node(data);
        temp.next = this.head;
        this.head = temp;
    }

    removeHead() {
        let temp = this.head;
        this.head = this.head.next;
        temp.next = null;
    }

    average() {
        let temp = this.head;
        let sum = 0;
        let ct = 0;
        while (temp.next != null) {
            sum += temp.value;
            ct++;
            temp = temp.next;
        }
        return sum / ct;
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
console.log(list.average());


// class Node{
//     constructor(data){
//         this.data = data;
//         this.next = null;
//     }
// }


// class singlyLinkedList{
//     constructor(){
//         this.head = null;
//     }

//     addToFront(data){
//         let newNode = new Node(data);
//         if(this.head === null){
//             this.head = newNode;
//             return;
//         }
//         newNode.next = this.head;
//         this.head = newNode;
//     }

//     addToBack(data){
//         if(this.head === null){
//             this.addToFront(data);
//             return;
//         }
//         let newNode = new Node(data);
//         let runner = this.head;
//         while(runner.next != null){
//             runner = runner.next;
//         }
//         runner.next = newNode;
//     }

//     addToBackN(arr){
//         let i = 0;
//         if(this.head === null){
//             this.head = new Node(arr[i]);
//             i++;
//         }
//         let runner = this.head;
//         while(runner.next != null){
//             runner = runner.next;
//         }

//         while(i < arr.length){
//             let newNode = new Node(arr[i]);
//             runner.next = newNode;
//             runner = runner.next;
//             i++;
//         }
//     }

//     removeFromFront(){
//         if(this.head === null){
//             return;
//         }
//         this.head = this.head.next;
//     }

//     toString(){
//         if(this.head === null) return;
//         console.log("Running toString: ");
//         let myStr = "";
//         let runner = this.head;
//         while(runner !== null){
//             myStr += runner.data + " -> ";
//             runner = runner.next;
//         }
//         console.log(myStr + " null");
//     }

//     isEmpty(){
//         if(this.head === null){
//             return true;
//         }
//         return false;
//     }

// }

// let mySll = new singlyLinkedList();
// mySll.toString();
// console.log(mySll.isEmpty());
// mySll.addToFront(32);
// // mySll.addToFront(64);
// // mySll.addToFront(128);
// // mySll.addToFront(256);
// mySll.addToBack(512);
// console.log(mySll.isEmpty());
// mySll.addToBackN([111,222,333,444,555]);
// // mySll.removeFromFront();
// mySll.toString();