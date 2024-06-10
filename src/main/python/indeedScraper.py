from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.service import Service
from bs4 import BeautifulSoup
import time

# Set up the WebDriver
service = Service('/usr/local/bin/chromedriver')  
driver = webdriver.Chrome(service=service)

# Function to scrape job listings from Indeed
def scrape_indeed_jobs(keyword, location):
    # Open Indeed website
    driver.get('https://www.indeed.com')
    
    # Find the search boxes and enter the keyword and location
    search_job = driver.find_element(By.ID, 'text-input-what')
    search_location = driver.find_element(By.ID, 'text-input-where')
    
    search_job.clear()

    # search_location.clear()
    # Ensure the location field is cleared before entering the location
    search_location.send_keys(Keys.COMMAND + "a")
    search_location.send_keys(Keys.DELETE)
  
    #send location
    search_location.send_keys(location)
    #send keyword
    search_job.send_keys(keyword)
    
    # Press enter to start the search
    search_job.send_keys(Keys.RETURN)
    
    # Wait for the page to load
    time.sleep(5)
    
    # Get the page source and create a BeautifulSoup object
    soup = BeautifulSoup(driver.page_source, 'html.parser')
    
    # Find job cards
    job_cards = soup.find_all('div', class_='job_seen_beacon')
    
    # Extract job information
    jobs = []
    for card in job_cards:
        title = card.find('h2', class_='jobTitle').get_text(strip=True)
        company = card.find('span', class_='companyName').get_text(strip=True)
        location = card.find('div', class_='companyLocation').get_text(strip=True)
        
        jobs.append({
            'title': title,
            'company': company,
            'location': location
        })
    
    return jobs

# Usage example
keyword = 'software engineer'
location = 'New York, NY'
jobs = scrape_indeed_jobs(keyword, location)

# Print the jobs
for job in jobs:
    print(f"Title: {job['title']}\nCompany: {job['company']}\nLocation: {job['location']}\n")

# Close the WebDriver
driver.quit()