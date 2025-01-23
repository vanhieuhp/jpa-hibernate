import aiohttp
import asyncio


async def fetch(session, url):
    async with session.get(url) as response:
        return await response.json()

async def update_payment(session, url, payment_data):
    async with session.put(url, json=payment_data) as response:
        return await response.json()

async def call_api_multiple_times(url, times=10):
    async with aiohttp.ClientSession() as session:
        tasks = []
        body = {
            "amount": 1
        }
        for _ in range(times):
#             tasks.append(update_payment(session, url, body))
            tasks.append(fetch(session, url))

        # Run the tasks concurrently
        responses = await asyncio.gather(*tasks)
        return responses


# Example usage
id = "40960684-0194-4e85-a607-e979deb35574"
# url = f"http://localhost:8080/api/v1/jpa/payments/{id}/decrease"  # Replace with your actual API
url = "http://localhost:8080/api/v1/jpa/movies/filter?year=2000" # fetch all movies year is 2000
async def main():
    responses = await call_api_multiple_times(url)
    for idx, response in enumerate(responses):
        print(f"Response {idx + 1}: {response}")


# Run the asyncio event loop
if __name__ == "__main__":
    asyncio.run(main())
