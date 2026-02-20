package com.gamedeveloper.shared

object LessonRepository {
    val lessons: List<Lesson> = listOf(
        Lesson(
            id = 1,
            title = "Introduction to Unity",
            summary = "Get started with the Unity engine and its editor.",
            content = """Unity is a cross-platform game engine used to build 2D and 3D games and simulations.

Key concepts:
• Unity Hub – manages your Unity installations and projects.
• The Editor – contains the Scene view, Game view, Inspector, Hierarchy, and Project panels.
• Assets – everything in your game (scripts, textures, audio, prefabs) lives in the Assets folder.
• Scenes – a Scene is a container for all GameObjects that make up a level or menu.

Getting started:
1. Download Unity Hub from unity.com.
2. Install a Unity LTS (Long-Term Support) version.
3. Create a new 2D or 3D project.
4. Explore the default scene containing a Main Camera and Directional Light."""
        ),
        Lesson(
            id = 2,
            title = "GameObjects & Components",
            summary = "Understand the building blocks of every Unity scene.",
            content = """Everything in a Unity scene is a GameObject. GameObjects are containers for Components that define their behaviour and appearance.

Core Components:
• Transform – stores position, rotation, and scale; every GameObject has one.
• Mesh Renderer – renders a 3D mesh on screen.
• Rigidbody – enables physics simulation (gravity, forces, collisions).
• Collider – defines the physical shape used for collision detection.
• Script – attach your own C# MonoBehaviour scripts.

Hierarchy panel:
Parent–child relationships let you group GameObjects. Moving the parent also moves all children.

Inspector panel:
Select any GameObject to view and edit its components and their properties."""
        ),
        Lesson(
            id = 3,
            title = "C# Basics for Unity",
            summary = "Learn the C# fundamentals you need to write Unity scripts.",
            content = """Unity scripts are written in C#. Here are the essentials:

Variables & Types:
  int score = 0;
  float speed = 5.5f;
  bool isAlive = true;
  string playerName = "Hero";

Operators:
  +  -  *  /  %   (arithmetic)
  == != < > <= >=  (comparison)
  && || !           (logical)

Control Flow:
  if (score > 100) { /* win */ }
  for (int i = 0; i < 10; i++) { }
  while (isAlive) { }

Methods:
  void Shoot() {
      // code here
  }

Classes:
  public class Player {
      public int health = 100;
      public void TakeDamage(int dmg) { health -= dmg; }
  }"""
        ),
        Lesson(
            id = 4,
            title = "MonoBehaviour & Lifecycle",
            summary = "How Unity calls your script methods automatically.",
            content = """Every Unity script inherits from MonoBehaviour, which hooks into Unity's game loop.

Key lifecycle methods:
• Awake()  – called once when the script is first loaded (before Start).
• Start()  – called once on the first frame the script is enabled.
• Update() – called every frame; use for gameplay logic and input.
• FixedUpdate() – called at a fixed timestep; use for physics.
• LateUpdate() – called after all Update() calls; good for cameras.
• OnDestroy() – called when the GameObject is destroyed.

Example:
  using UnityEngine;

  public class PlayerController : MonoBehaviour {
      float speed = 5f;

      void Start() {
          Debug.Log("Player spawned!");
      }

      void Update() {
          float h = Input.GetAxis("Horizontal");
          transform.Translate(h * speed * Time.deltaTime, 0, 0);
      }
  }

Time.deltaTime ensures movement is frame-rate independent."""
        ),
        Lesson(
            id = 5,
            title = "Transforms & Movement",
            summary = "Position, rotate, and scale GameObjects with Transform.",
            content = """The Transform component controls where a GameObject is in the world.

Properties:
• transform.position   – world-space position (Vector3)
• transform.localPosition – position relative to parent
• transform.rotation   – rotation as a Quaternion
• transform.eulerAngles – rotation in degrees (easier to read)
• transform.localScale – size relative to parent

Useful methods:
• transform.Translate(x, y, z) – move by an offset
• transform.Rotate(x, y, z)    – rotate by degrees
• transform.LookAt(target)     – rotate to face a target

Vector3 helpers:
  Vector3.zero    // (0, 0, 0)
  Vector3.up      // (0, 1, 0)
  Vector3.forward // (0, 0, 1)
  Vector3.Distance(a, b) // distance between two points

Example – move toward a target:
  transform.position = Vector3.MoveTowards(
      transform.position, target.position, speed * Time.deltaTime);"""
        ),
        Lesson(
            id = 6,
            title = "Physics & Collisions",
            summary = "Use Rigidbody and Colliders to simulate physics.",
            content = """Unity's physics engine (PhysX) handles realistic movement and collisions.

Rigidbody settings:
• Mass – how heavy the object is.
• Drag – air resistance on linear movement.
• Angular Drag – resistance to rotation.
• Use Gravity – enable/disable gravity.
• Is Kinematic – move via script instead of physics forces.

Applying forces in script:
  Rigidbody rb;
  void Start() { rb = GetComponent<Rigidbody>(); }
  void Jump() { rb.AddForce(Vector3.up * 300f); }

Collision callbacks:
  void OnCollisionEnter(Collision col) {
      Debug.Log("Hit: " + col.gameObject.name);
  }

Trigger callbacks (set Collider "Is Trigger" = true):
  void OnTriggerEnter(Collider other) {
      if (other.CompareTag("Coin")) Collect(other.gameObject);
  }

Layers & Physics Matrix:
Use Edit > Project Settings > Physics to control which layers interact."""
        ),
        Lesson(
            id = 7,
            title = "User Input",
            summary = "Read keyboard, mouse, and touch input in your scripts.",
            content = """Unity provides several ways to read player input.

Input class (classic):
  // Axes (returns -1 to 1)
  float h = Input.GetAxis("Horizontal");
  float v = Input.GetAxis("Vertical");

  // Buttons
  if (Input.GetKeyDown(KeyCode.Space)) Jump();
  if (Input.GetKey(KeyCode.LeftShift)) Sprint();
  if (Input.GetKeyUp(KeyCode.E)) Interact();

  // Mouse
  float mouseX = Input.GetAxis("Mouse X");
  if (Input.GetMouseButtonDown(0)) Shoot(); // left click

  // Touch (mobile)
  if (Input.touchCount > 0) {
      Touch touch = Input.GetTouch(0);
      if (touch.phase == TouchPhase.Began) Tap(touch.position);
  }

New Input System (Unity 2019+):
• Install via Package Manager > Input System.
• Create Input Action assets for cleaner, rebindable controls.
• Use PlayerInput component for automatic method routing."""
        ),
        Lesson(
            id = 8,
            title = "UI with Unity Canvas",
            summary = "Build menus, HUDs, and overlays using uGUI.",
            content = """Unity's built-in UI system (uGUI) uses a Canvas as the root container.

Canvas Render Modes:
• Screen Space – Overlay: UI always on top of everything.
• Screen Space – Camera: UI rendered by a specific camera.
• World Space: UI exists as an object in the 3D world.

Common UI Components:
• Text / TextMeshPro – displays strings.
• Image – shows a Sprite.
• Button – responds to clicks.
• Slider – selects a value in a range.
• Toggle – on/off checkbox.
• ScrollView – scrollable list content.

Scripting UI:
  using UnityEngine.UI;
  using TMPro; // TextMeshPro

  public TextMeshProUGUI scoreText;
  public Button playButton;

  void Start() {
      playButton.onClick.AddListener(StartGame);
  }

  void UpdateScore(int score) {
      scoreText.text = "Score: " + score;
  }

Anchors & Pivot:
Set anchors so UI elements position correctly on different screen sizes."""
        ),
        Lesson(
            id = 9,
            title = "Audio in Unity",
            summary = "Add sound effects and music to your game.",
            content = """Unity's audio system uses AudioSource and AudioClip components.

Setup:
1. Import an audio file (MP3, WAV, OGG) into Assets.
2. Add an AudioSource component to a GameObject.
3. Assign the AudioClip to the AudioSource's Clip field.

AudioSource properties:
• Clip – the sound to play.
• Play On Awake – auto-play when the scene loads.
• Loop – repeat the clip continuously (good for music).
• Volume – 0.0 to 1.0.
• Pitch – 1.0 is normal; <1 lower, >1 higher.
• Spatial Blend – 0 = 2D, 1 = 3D positional audio.

Scripting audio:
  AudioSource audioSource;
  public AudioClip jumpSound;

  void Start() { audioSource = GetComponent<AudioSource>(); }

  void Jump() {
      audioSource.PlayOneShot(jumpSound);
  }

AudioListener:
The Main Camera has an AudioListener by default. 3D audio volume and panning are relative to this listener."""
        ),
        Lesson(
            id = 10,
            title = "Building Your First Game",
            summary = "Put it all together and build a runnable game.",
            content = """Follow these steps to create and build a simple complete game:

1. Plan your game – genre, core mechanic, win/lose condition.

2. Set up the project:
   • New 2D project in Unity Hub.
   • Create folders: Scripts, Prefabs, Sprites, Audio, Scenes.

3. Create a Player:
   • Add a Sprite Renderer + Rigidbody2D + BoxCollider2D.
   • Write a PlayerController script (movement + jump).

4. Add a platform / level:
   • Create a Tilemap or simple sprite platforms with Colliders.

5. Add a Goal:
   • A collectible with a Trigger Collider.
   • On collection, add score and play a sound.

6. Build a HUD:
   • Canvas with a score Text and a "Game Over" panel (hidden by default).

7. Add a Game Manager:
   • Singleton script to track score, lives, and scene loading.

8. Test in the Editor with Play mode.

9. Build & Run:
   • File > Build Settings > Android.
   • Switch Platform, set Package Name, click Build.
   • Install the APK on a device or emulator.

Congratulations – you've built your first Unity game!"""
        )
    )

    fun getLessonById(id: Int): Lesson? = lessons.find { it.id == id }
}
