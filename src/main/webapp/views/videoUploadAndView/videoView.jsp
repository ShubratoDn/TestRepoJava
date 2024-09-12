<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video View Page</title>
</head>
<body>

<div>
        <video controls id="videoSource" src="">
        </video>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            // Fetch the video URL from the server
            fetchVideo();

            function fetchVideo() {
                // Replace 'videoName' with the actual name of the video file
                const videoName = "video.mp4";
                
                fetch(`/videos/video.mp4`)
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(`Failed to fetch video: ${response.status}`);
                        }
                        return response.blob();
                    })
                    .then(blob => {
                        // Create a Blob URL for the video
                        const videoUrl = URL.createObjectURL(blob);
                        // Set the video source
                        const videoElement = document.getElementById("videoSource");
                        videoElement.src = videoUrl;
                    })
                    .catch(error => {
                        console.error("Error fetching video:", error);
                    });
            }
        });
    </script>

</body>
</html>