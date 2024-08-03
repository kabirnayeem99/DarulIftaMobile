import json

import requests
from bs4 import BeautifulSoup

# Target URL for scraping
url = "https://darulifta-deoband.com/home/en/dua-supplications/708"

# Fetch the HTML content
response = requests.get(url)
response.raise_for_status()  # Raise exception for non-200 status codes

# Parse the HTML content
html_content = response.content

# Parse the HTML content
soup = BeautifulSoup(html_content, "html.parser")


# Define a function to extract data from each category section
def extract_category_data(cat_section):
    category_name = cat_section.find("h3").text.strip()
    sub_categories = []
    for sub_item in cat_section.find("ul").find_all("li"):
        sub_category_name = (
            sub_item.find("a").text.replace("(", "").replace(")", "").strip()
        )  # Get name without count
        sub_category_url = sub_item.find("a")["href"]
        sub_categories.append({"name": sub_category_name, "url": sub_category_url})
    return {"category_name": category_name, "sub_categories": sub_categories}


# Extract data from all category sections
categories = []
for cat_section in soup.find_all("div", class_="cat_part_sec"):
    categories.append(extract_category_data(cat_section))

# Convert data to JSON format
json_data = json.dumps(categories, indent=4)

# Print or save the JSON data
print(json_data)

# (Optional) Save to a file
with open("categories.json", "w") as f:
    f.write(json_data)
