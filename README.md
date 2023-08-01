# codingTest
# Recently Played Songs Store

This is a Java program that implements an in-memory store for recently played songs. 
The store can accommodate N songs per user, with a fixed initial capacity. It allows storing a list of song-user pairs, with each song linked to a user. 
The store also automatically removes the least recently played songs when it becomes full.

## Table of Contents
- [Overview](#overview)
- [Example](#example)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Overview

The program includes two classes:
- `RecentlyPlayedSongsStore`: Represents the in-memory store for recently played songs. It has methods to add recently played songs for a user and fetch the recently played songs for a user.
- `RecentlyPlayedSongsStoreTest`: Contains JUnit tests to verify the functionality of the `RecentlyPlayedSongsStore` class.

## Example

Illustration, when 4 different songs were played by a user & Initial capacity is 3:
Let's assume that the user has played 3 songs - S1, S2, and S3.
The playlist would look like -> S1, S2, S3
When S4 song is played -> S2, S3, S4
When S2 song is played -> S3, S4, S2
When S1 song is played -> S4, S2, S1

## Usage

To use the `RecentlyPlayedSongsStore` class in your Java project, follow these steps:

1. Clone or download the repository.
2. Copy the `RecentlyPlayedSongsStore.java` file to your project.
3. Import the necessary packages as shown in the examples.

## Dependencies

The `RecentlyPlayedSongsStore` class does not have any external dependencies other than standard Java libraries.

## Testing

JUnit 5 is used for testing the functionality of the `RecentlyPlayedSongsStore` class. The test class `RecentlyPlayedSongsStoreTest` contains test cases that ensure the correct behavior of the class.

To run the tests, you can use any IDE with JUnit support or use Maven with the command "mvn test".
