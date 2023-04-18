function toggleFollow(button) {
  if (button.innerHTML === "팔로우") {
    button.innerHTML = "팔로잉";
    button.classList.toggle("following", true);
    button.classList.toggle("follow", false);
  } else {
    button.innerHTML = "팔로우";
    button.classList.toggle("following", false);
    button.classList.toggle("follow", true);
  }
}
