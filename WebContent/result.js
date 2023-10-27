function loadPage() {
  const box = document.getElementById('box');

  fetch('result.html')
    .then(response => response.text())
    .then(html => {
      box.innerHTML = html;
    })
    .catch(error => {
      console.log(error);
    });
}

loadPage();
