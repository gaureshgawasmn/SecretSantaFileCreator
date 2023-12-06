# Secret Santa Assignment Program

This Java program assigns Secret Santas to a group of participants and creates individual files for each participant with their Secret Santa assignment.

## Overview

The program reads a file containing a list of participants with their names and emails in the following format:

Name1  
Email1  
Name2  
Email2 

...


It then assigns each participant a Secret Santa from the group and creates a separate file for each participant with their assigned Secret Santa.

## Usage

1. **File Format**: Ensure the participant file (`participants.txt`) follows the specified format: each participant's name followed by their email address on separate lines.

2. **Run the Program**: Execute the `SecretSantaFileCreator.java` file.

3. **Output**: After execution, the program creates individual files for each participant in the format: `ParticipantName_SecretSanta.txt`, containing their Secret Santa assignment.

## How It Works

- **Loading Participants**: The program reads the participant data from `participants.txt`.
- **Assigning Secret Santas**: It shuffles the list of participant names and assigns each participant a Secret Santa while ensuring no self-assignment.
- **File Creation**: For each participant, it generates a text file containing their Secret Santa assignment.

## Requirements

- JavaMail API (for sending emails, if needed)
- Java 8 or higher

## Configuration

- Modify the `participants.txt` file to include the list of participants in the required format.
- Configure the email settings in the code (`SecretSantaFileCreator.java`) if you want to send emails instead of creating files.

## Note

- Ensure that the program has proper permissions to read/write files in the specified directory.
- Modify the code according to specific requirements or additional constraints if needed.

Feel free to adjust the code or instructions according to your setup and requirements.
