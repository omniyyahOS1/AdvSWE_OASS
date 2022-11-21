# Client Readme
## Overview
The client is itself an API. It has fixed endpoints that are designed to test
the endpoints of our service end-to-end.

It is programmed in Python using the FastAPI library and requires our service to
be up and running in order to work. Right now I have it so that it is hitting
the local endpoints but I can change that pretty easily to hit our Heroku
instance when the time comes.

## How to Run

### Requirements
- Make sure you have [Python 3](https://www.python.org/downloads/) installed.
I'm running 3.10 but any Python 3 should be fine

### Steps
1. On the command line, create a virtual environment for all your dependencies
    - From the root of the client folder run the command 
    ```python -m venv client-env```
    - you can name the virtual environment anything you want but `client-env` is
    ignored by git and is what I use going forward.
2. Start the virtual environment
    - On Unix/MacOS in bash: `source client-env/bin/activate`
    - On Unix/MaxOS in csh: `source client-env/bin/activate.csh`
    - On Windows cmd: `client-env\Scripts\activate.bat`
    - On Windows PowerShell: `client-env\Scripts\Activate.ps1`
    - You should see your environment name in the shell (can confirm on Windows)
2. Install the dependencies
    - On the command line run `pip install -r requirements.txt`
3. Run the app
    - On the command line run `uvicorn main:app --reload`
    - Make sure that you also have our service up and running locally (will
    change the implementation to use the Heroku instance later)
    - the `--reload` flag allows you to make changes to the app while it runs
    without having stop the app and restart it in order to see the changes
3. Open the app
    - go to http://localhost:8000/docs in order to see the Swagger for all the
    endpoints