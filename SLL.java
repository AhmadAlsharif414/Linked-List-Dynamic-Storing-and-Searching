public class SLL<T>{
    private SLLNode<T> head;

    public SLL() {
        this.head = null;
    }

    public SLLNode<T> getHead() {
        return head;
    }

    public static class SLLNode<T> {
        public T data;
        public SLLNode<T> next;

        public SLLNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //O(N)
    public void insert(T data) {
        SLLNode<T> newNode = new SLLNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            SLLNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //O(N)
    public boolean compareCitySLL(String cityName) {
        SLLNode<T> current = head;
        while (current != null) {
            City city = (City) current.data;
            if (city.getName().equalsIgnoreCase(cityName)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //O(N)
    public City findCitySLL(String key) {
        SLLNode<T> current = head;
        City city;
        while (current != null) {
            city = (City) current.data;
            if (city.getName().equalsIgnoreCase(key)) {
                return city;
            }
            current = current.next;
        }
        return null;
    }

    //O(N)
    public void insertAtPosition(T data, int position) throws Exception {
        if (position < 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("invalid position");
            }
            return;
        }

        SLLNode<T> newNode = new SLLNode<>(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            SLLNode<T> current = head;
            int currentPosition = 1;

            while (current != null && currentPosition < position - 1) {
                current = current.next;
                currentPosition++;
            }

            if (current == null) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Invalid position: " + position);
                }
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    //O(N)
    public void deleteCity(String cityName) throws Exception {
        if (head == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("List is empty. Cannot delete city.");
            }
        }

        if (cityName.equalsIgnoreCase(((City) head.data).getName())) {
            head = head.next;
            return;
        }

        SLLNode<T> current = head;

        while (current.next != null) {
            if (cityName.equalsIgnoreCase(((City) current.next.data).getName())) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        throw new Exception("City not found in the list.");
    }
}