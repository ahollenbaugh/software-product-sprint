// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Displays a random Napoleon Dynamite quote on the page.
 */
function getRandomQuote() {
    const quote_list =
        ['How much you wanna bet I can throw a football over the mountains?', 'Grandma says you\'re ruining our lives and eating all our steak!', 'Your mom goes to college!', 'You\'re just jealous because I\'ve been chatting online with babes, all day.', 'I like your sleeves; they\'re real big.'];

    // Pick a random quote.
    const random_quote = quote_list[Math.floor(Math.random() * quote_list.length)];

    // Display.
    const quoteContainer = document.getElementById('quote-container');
    quoteContainer.innerText = random_quote;
}

/** Fetches hardcoded string from the server and adds it to the page. */
async function showRandomFact() {
    // Fetch JSON from server
    const responseFromServer = await fetch('/hello');

    // Parse JSON
    const facts = await responseFromServer.json();

    // Pick a random fact
    const random_fact = facts[Math.floor(Math.random() * facts.length)];

    // Display a random fact
    const factContainer = document.getElementById('fact-container');
    factContainer.innerText = random_fact;
}

function requestTranslation() {
    const text = document.getElementById('text').value;
    const languageCode = document.getElementById('language').value;

    const resultContainer = document.getElementById('result');
    resultContainer.innerText = 'Loading...';

    const params = new URLSearchParams();
    params.append('text', text);
    params.append('languageCode', languageCode);

    fetch('/translate', {
        method: 'POST',
        body: params
    }).then(response => response.text())
      .then((translatedMessage) => {
          resultContainer.innerText = translatedMessage;
        });
}

