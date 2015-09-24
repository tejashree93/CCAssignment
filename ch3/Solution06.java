/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author Tejashree pc
 */
public class Solution06 {
    public static void main(String args[]) throws IOException
    {
        Scanner sc=new Scanner (System.in);
        String s=new String();
        String animal=new String();
        Queue q=new Queue();
        while(true)
        {
            System.out.println("Choose the operations to be performed, enter from the number indicated for each operation: ");
            System.out.println("1. put Dog  or 2. put Cat or 3. get Animal 4. get Dog 5. get Cat 6. Display Animals 7. number of animals 8. exit");
            int opt=sc.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.println("Enter the name of dog:");
                    s=sc.next();
                    Dog d=new Dog(s); 
                    q.enqueue(d);
                    break;
                case 2:
                    System.out.println("Enter the name of cat:");
                    s=sc.next();
                    Cat c=new Cat(s); 
                    q.enqueue(c);
                    break;
                case 3:
                    animal = q.dequeueAny();
                    if(animal==null)
                        break;
                    System.out.print("The animal is ");
                    if(animal.charAt(0)=='c')
                        System.out.print("a cat and its name is "+animal.substring(1));
                    if(animal.charAt(0)=='d')
                        System.out.print("a dog and its name is "+animal.substring(1));
                    System.out.println();
                    break;
                case 4:
                    animal = q.dequeueDog();
                    if(animal==null)
                        break;
                    System.out.println("The dog's name is "+animal);
                    break;
                case 5:
                    animal = q.dequeueCat();
                    if(animal==null)
                        break;
                    System.out.println("The cat's name is "+animal);
                    break;
                case 6:
                    q.displayAnimals();
                    break;
                case 7:
                    System.out.println("Number of animals: "+q.size());
                    break;
                case 8:
                    return;
            }
        }
    }
}
class Animal
{
    String name;
    Animal(){}
    Animal(String name)
    {
        this.name=name;
    }
}

class Cat extends Animal
{
    Cat(){}
    Cat(String name)
    {
        super.name = "c"+name;
    }
}

class Dog extends Animal
{
    Dog(){}
    Dog(String name)
    {
        super.name="d"+name;
    }
}

class Queue
{
    int front=-1,rear;
    LinkedList l=new LinkedList();
    void enqueue(Animal a)
    {
        l.add(a);
        front=0;
        rear=l.size()-1;
    }
    int size()
    {
        return l.size();
    }
    String dequeueAny()
    {
        if(front==-1)
        {
            System.out.println("No animals in the shelter!");
            return null;
        }
        Animal a=(Animal)l.get(front);
        l.removeFirst();
        rear = l.size()-1;
        if(l.size()==0)
            front=-1;
        return a.name;
    }
    
    String dequeueDog()
    {
        String dog=new String();
        int track = front;
        if(front==-1)
        {
            System.out.println("No animals in the shelter!");
            return null;
        }
        while(track<=rear)
        {
            Animal a = (Animal)l.get(track);
            if(a.name.charAt(0)=='d')
            {
                dog = a.name;
                l.remove(track);
                rear=l.size()-1;
                if(l.size()==0)
                    front=-1;
                return dog.substring(1);
            }
            track++;
        }
        System.out.println("No dogs in the shelter");
        return null;
    }
    
    String dequeueCat()
    {
        String cat=new String();
        int track = front;
        if(front==-1)
        {
            System.out.println("No animals in the shelter!");
            return null;
        }
        while(track<=rear)
        {
            Animal a = (Animal)l.get(track);
            if(a.name.charAt(0)=='c')
            {
                cat = a.name;
                l.remove(track);
                rear=l.size()-1;
                if(l.size()==0)
                    front=-1;
                return cat.substring(1);
            }
            track++;
        }
        System.out.println("No cats in the shelter");
        return null;
    }
    
    void displayAnimals()
    {
        if(front==-1)
        {
            System.out.println("No animals in the shelter!");
            return;
        }
        System.out.println("Animals in the shelter are:");
        for(int i=front;i<=rear;i++)
        {
            Animal a= (Animal) l.get(i);
            if(a.name.charAt(0)=='d')
                System.out.print("dog-"+a.name.substring(1)+" ");
            else
                System.out.print("cat-"+a.name.substring(1)+" ");
        }
        System.out.println();
    }
}
