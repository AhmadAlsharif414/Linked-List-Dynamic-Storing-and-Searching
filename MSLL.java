public class MSLL<T extends City>{

    public class MSLLNode<T> {
        public String key;
        public SLL<T> list;
        public MSLLNode<T> next;

        public MSLLNode(String key, SLL<T> list) {
            this.key = key;
            this.list = list;
            this.next = null;
        }
    }

    private MSLLNode<T> head;
    private MSLLNode<T> tail;

    public MSLL() {
        this.head = null;
    }

    //O(N)
    public void insert(SLL<T> list, String key) {
        MSLLNode<T> newNode = new MSLLNode<>(key, list);
        if (head == null) {
            head = newNode;
            System.out.println("New node inserted");
        } else {
            MSLLNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            System.out.println("New node inserted");
        }
    }

    //O(N)
    public void addToMSLLHead(String key){
        SLL<T> newList = new SLL<>();
        MSLLNode<T> newNode = new MSLLNode(key, newList);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("MSLL added to head");
        } else {
            boolean nodeCheck = isInMSLList(key);
            if (nodeCheck){
                try {
                    throw new Exception();
                } catch (Exception e){
                    System.out.println("Node already exists");
                }
            } else {
                newNode.next = head;
                head = newNode;
                System.out.println("MSLL added to head");
            }
        }
    }

    //O(N)
    public boolean isInMSLList(String key) {
        MSLLNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.key.equalsIgnoreCase(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    //O(N)
    public void addToMSLLTail(String key){
        SLL<T> newList = new SLL<>();
        MSLLNode<T> newNode = new MSLLNode(key, newList);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("Node added to tail");
        } else {
            boolean nodeCheck = isInMSLList(key);
            if (nodeCheck){
                try {
                    throw new Exception();
                } catch (Exception e){
                    System.out.println("Node already exists");
                }
            } else {
                tail.next = newNode;
                tail = newNode;
                System.out.println("Node added to tail");
            }
        }
    }

    //O(N)
    public void deleteFromMSLL(String key){
        if (head == null){
            try {
                throw new Exception();
            } catch (Exception e){
                System.out.println("Node does not exist");
            }
        } else if (head.key.equalsIgnoreCase(key)){
            head = head.next;
            System.out.println("Node deleted");
            return;
        } else {
            MSLLNode currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.key.equalsIgnoreCase(key)) {
                    if (currentNode.next == tail){
                        tail = currentNode;
                    }
                    currentNode.next = currentNode.next.next;
                    System.out.println("Node deleted");
                    return;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }
        try {
            throw new Exception();
        } catch (Exception e){
            System.out.println("Node does not exist");
        }
    }

    //O(N)
    public void makeCitySublistEmpty(String key) {
        MSLLNode<T> current = head;
        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                current.list = new SLL<>();
                System.out.println("List made empty");
                return;
            }
            current = current.next;
        }
        try {
            throw new Exception();
        } catch (Exception e){
            System.out.println("City Does not exist");
        }
    }

    //O(N)
    public void deleteCitySublist(String key) throws Exception {
        try {
            if (head != null && head.key.equalsIgnoreCase(key)) {
                head = head.next;
                System.out.println("City Sublist deleted");
            } else {
                MSLLNode<T> current = head;
                while (current != null && current.next != null) {
                    if (current.next.key.equalsIgnoreCase(key)) {
                        current.next = current.next.next;
                        System.out.println("City Sublist deleted");
                        break;
                    }
                    current = current.next;
                }
                if (current == null || current.next == null) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Sublist not found!");
                    }
                }
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }

    //O(M+N)
    public void displayCitySublist(String key) {
        MSLLNode<T> current = head;
        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                SLL.SLLNode<T> sublistNode = current.list.getHead();
                while (sublistNode != null) {
                    City city = (City) sublistNode.data;
                    System.out.println(city.getName());
                    sublistNode = sublistNode.next;
                }
                break;
            }
            current = current.next;
        }
    }

    //O(N^2)
    public void addCityToSublistAtRear(T city) {
        MSLLNode<T> current = head;
        try {
            while (current != null) {
                if (current.list.compareCitySLL(city.getName())) {
                    try {
                        throw new Exception();
                    } catch (Exception e){
                        System.out.println("City Already exists");
                    };
                    return;
                }
                if (current.key.equalsIgnoreCase(city.getName().substring(0, 1))) {
                    current.list.insert(city);
                    System.out.println("City added");
                    break;
                }
                current = current.next;
            }
            if (current == null) {
                SLL<T> newList = new SLL<>();
                newList.insert(city);
                insert(newList, city.getName().substring(0, 1));
                System.out.println("City added");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //O(N^2)
    public void addCityToSublistAtPosition(T e1, int position) throws Exception {
        if (position < 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid position: " + position);
            }
            return;
        }


        if (compareCityMSLL(e1.getName())) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("City already exists in the sublist!");
            }
            return;
        }


        if (!isInMSLList(e1.getName().substring(0, 1))) {
            SLL<T> newList = new SLL<>();
            insert(newList, e1.getName().substring(0, 1));
        }

        MSLLNode<T> current = head;
        while (current != null) {
            if (current.key.equalsIgnoreCase(e1.getName().substring(0, 1))) {
                current.list.insertAtPosition(e1, position);
                System.out.println("City added");
                return;
            }
            current = current.next;
        }

        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Sublist not found for city insertion!");
        }
    }

    //O(N^2)
    public boolean compareCityMSLL(String cityName) {
        MSLLNode<T> current = head;
        while (current != null) {
            if (current.list.compareCitySLL(cityName)) {
                return current.list.compareCitySLL(cityName);
            }
            current = current.next;
        }
        return false;
    }


    //O(N^2)
    public City findCityMSLL(String cityName) {
        MSLLNode<T> current = head;
        while (current != null) {
            if (current.list.compareCitySLL(cityName)) {
                return current.list.findCitySLL(cityName);
            }
            current = current.next;
        }
        return null;
    }

    //O(N^2)
    public void deleteCityFromSublist(String city) throws Exception {
        MSLLNode<T> current = head;
        while (current != null) {
            if (current.list.compareCitySLL(city)) {
                current.list.deleteCity(city);
                System.out.println("City deleted");
                return;
            }
            current = current.next;
        }

        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("City not found in any sublist!");
        }
    }
}