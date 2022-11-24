import json
import requests
from fastapi import APIRouter
from requests import Response

from constants import CLIENT_TAG
from routers.router_constants import SIGNUP_URL, TOKEN_PATH

router = APIRouter(
    prefix="/clients",
    tags=[CLIENT_TAG]
)



@router.get("/signup")
async def sign_up(email : str = "dummy@test.com"):
    """
    Signs up for the service

    Example response:
    ```json
    {
        "token" : "some_random_string"
    }    
    ```
    """

    try:
    
        r : Response = requests.post(url=SIGNUP_URL, params = {"email" : email})
        json_data = json.loads(r.text)
        token = json_data["token"]

        outfile = open(TOKEN_PATH, "a")
        outfile.write(token)
        outfile.close()

        return json_data
    
    except Exception as e:
        return {"Exception ocurred" : e.__str__()}
