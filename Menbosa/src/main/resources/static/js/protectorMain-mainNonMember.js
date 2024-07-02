const bannerPrevButton = document.querySelector(".protectorMain-bannerMove > button:nth-of-type(1)");
const bannerNextButton = document.querySelector(".protectorMain-bannerMove > button:nth-of-type(2)");
const banner = document.querySelector(".protectorMain-bannerImg");


let currentIndex = 0;
const bannerWidth = 970;


bannerPrevButton.addEventListener("click", () => {
  console.log("클릭");
  currentIndex--;
  currentIndex = (currentIndex < 0) ? 0 : currentIndex;
  console.log(currentIndex);
  updateBanner2Position();
});

bannerNextButton.addEventListener("click", () => {
  console.log("클릭3");
  currentIndex = (currentIndex < 2) ? currentIndex + 1 : 0;
  updateBanner2Position();
});

function updateBanner2Position() {
  banner.style.transform = `translateX(-${currentIndex * bannerWidth}px)`;
  banner.style.transition = "0.5s ease";
}

//=========================================================

const bannerPrevButton2 = document.querySelector(".protectorMain-noticeMoveBtn > button:nth-of-type(1)");
const bannerNextButton2 = document.querySelector(".protectorMain-noticeMoveBtn > button:nth-of-type(2)");
const banner2 = document.querySelector(".protectorMain-noticeCnt");
let noticeLength = document.querySelectorAll(".protectorMain-noticeCnt > li");

console.log(noticeLength.length);
let currentIndex2 = 0;
const bannerWidth2 = 332;


bannerPrevButton2.addEventListener("click", () => {
  console.log("클릭");
  currentIndex2--;
  currentIndex2 = (currentIndex2 < 0) ? 0 : currentIndex2;
  console.log(currentIndex2);
  updateBannerPosition();
});

bannerNextButton2.addEventListener("click", () => {
  console.log("클릭2");
  currentIndex2 = (currentIndex2 < 3) ? currentIndex2 + 1 : 0;
  updateBannerPosition();
});

function updateBannerPosition() {
  banner2.style.transform = `translateX(-${currentIndex2 * bannerWidth2}px)`;
  banner2.style.transition = "0.5s ease";
}

