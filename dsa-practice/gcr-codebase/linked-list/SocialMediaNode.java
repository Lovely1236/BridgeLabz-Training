class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int id) {
        friendId = id;
        next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends;
    UserNode next;

    UserNode(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

class SocialMedia {
    UserNode head;

    public void addUser(int id, String name, int age) {
        UserNode node = new UserNode(id, name, age);
        node.next = head;
        head = node;
    }

    public void addFriend(int id1, int id2) {
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);

        if (u1 == null || u2 == null) return;

        FriendNode f1 = new FriendNode(id2);
        f1.next = u1.friends;
        u1.friends = f1;

        FriendNode f2 = new FriendNode(id1);
        f2.next = u2.friends;
        u2.friends = f2;
    }

    public void displayFriends(int id) {
        UserNode user = findUser(id);
        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private UserNode findUser(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Mahima", 21);
        sm.addUser(2, "Malay", 22);
        sm.addUser(3, "Garima", 23);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);

        sm.displayFriends(1);
    }
}