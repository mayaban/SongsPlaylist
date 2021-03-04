package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        // Create a program that implements a playlist for songs.
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // Songs from different albums can be added to the playlist and will
        // appear in the list in the order they are added.
        // Once the songs have been added to the playlist,create a menu pf options
        // to:-
        // Quit,Skip forward to the next song,skip backward to a previous song.
        // Replay the current song.
        // A song must exist in an album before it can be added to the playlist(so that
        // you can only play songs that you own).
        // Hint: To replay a song,consider what happened when we went back and forth
        // from a city before we started tracking the direction we were going.
        // As an optional extra,provide an option to remove the current song from the playlist.
        Album album = new Album("High Voltage", "AC/DC");
        album.addSong("Back in Black", 6.00);
        album.addSong("Hells Bell", 5.55);
        album.addSong("High Voltage", 4.55);
        album.addSong("ThunderStruck", 4.55);
        album.addSong("Shoot To Thrill", 3.90);

        albums.add(album);

        album = new Album("GnR", "Appetite for Destruction");
        album.addSong("Patience", 5.55);
        album.addSong("November Rain", 3.59);
        album.addSong("Civil War", 4.58);
        album.addSong("Knocking on Heavens Door", 6.39);
        album.addSong("Sweet O' Child Mine", 5.39);

        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlayList("Back in Black", playlist);
        albums.get(0).addToPlayList("Hells Bell", playlist);
        albums.get(0).addToPlayList("Strange", playlist);
        albums.get(1).addToPlayList(1, playlist);
        albums.get(1).addToPlayList(2, playlist);
        albums.get(1).addToPlayList(3, playlist);
        albums.get(1).addToPlayList(4, playlist);
        albums.get(1).addToPlayList(5, playlist);


        play(playlist);
    }

    public static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("there is no song in the playlist");
        } else {
            System.out.println("now palying " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;

                    }
                    if (listIterator.hasNext()) {
                        System.out.println("now playing " + listIterator.next().toString());

                    } else {
                        System.out.println("We have reached the end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We have reached the beginning of the list");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("we are replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("we are at the beginning of the list");
                        }
                    } else {

                        if (listIterator.hasNext()) {
                            System.out.println("we are replaying  " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("we are at the end of the list ");
                        }
                    }

                    break;

                case 4:
                    printLIst(playlist);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing  " + listIterator.next());
                        }else{
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing " + listIterator.previous());
                            }
                        }
                    }
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\n press");
        System.out.println("0 - to quit \n" +
                "1 - to play next song \n" +
                "2 - to play previous song \n" +
                "3 - to replay the current song \n" +
                "4 - list of songs in the playlist\n" +
                "5 - print available actioons\n" +
               "6 - remove current song from the playlist" );

    }

    private static void printLIst(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("====================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===================");
    }

}
