import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.MatteBorder;

public class OOPGUIFinalProjectMusicalizer extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 2510184156521567106L;
	private List<Music> musicLibrary;
	private boolean isOpen;
	private boolean isPlaying;
	private JPanel mainPanel;
	private JTextArea outputTextArea;
	private JButton openButton;
	private JButton addButton;
	private JButton viewButton;
	private JButton deleteButton;
	private JButton editButton;
	private JButton playButton;
	private JButton stopButton;
	private JButton quitButton;

	public OOPGUIFinalProjectMusicalizer() {
		// Create the introduction frame
		JFrame introFrame = new JFrame();
		introFrame.setSize(400, 300);
		introFrame.setLocationRelativeTo(null);
		introFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		introFrame.setUndecorated(true);
		introFrame.setBackground(new Color(0, 0, 0, 0));

		JPanel introPanel = new JPanel(new GridBagLayout());
		introPanel.setBackground(new Color(0, 0, 0, 200));
		introFrame.add(introPanel);

		JLabel titleLabel = new JLabel("Musicalizer");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
		titleLabel.setForeground(Color.GREEN);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 10, 0); // Add spacing below the title
		introPanel.add(titleLabel, gbc);

		JLabel taglineLabel = new JLabel("The Music Lyrics Visualizer");
		taglineLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		taglineLabel.setForeground(Color.GREEN);
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0); // Reset insets for the tagline
		introPanel.add(taglineLabel, gbc);

		introFrame.setVisible(true);

		// Show the introduction frame for 5 seconds (5000 milliseconds)
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		introFrame.dispose();

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\johnd\\OneDrive\\Pictures\\Wallpaper.jpg"));

		UIManager.put("OptionPane.messageForeground", Color.GREEN);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);// Set frame background color to black
		musicLibrary = new ArrayList<>();
		isOpen = false;
		isPlaying = false;

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK); // Set main panel background color to black
		mainPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK)); // Set main panel border color to black
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[] { 331, 0 };
		gbl_mainPanel.rowHeights = new int[] { 288, 47, 0 };
		gbl_mainPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_mainPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		mainPanel.setLayout(gbl_mainPanel);
		outputTextArea = new JTextArea(15, 30);
		outputTextArea.setForeground(Color.GREEN); // Set text area text color to green
		outputTextArea.setWrapStyleWord(true);
		outputTextArea.setBackground(Color.BLACK); // Set output text area background color to black
		JScrollPane scrollPane = new JScrollPane(outputTextArea);
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK)); // Set scroll pane border color to black

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		mainPanel.add(scrollPane, gbc_scrollPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Musicalizer | The Music Lyrics Visualizer!");
		getContentPane().add(mainPanel);

		JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 5, 5));
		buttonPanel.setForeground(Color.GREEN);
		buttonPanel.setBackground(Color.BLACK);
		addButton = new JButton("ADD");
		addButton.setForeground(Color.GREEN);
		addButton.setBackground(Color.BLACK);
		viewButton = new JButton("PLAYLIST");
		viewButton.setForeground(Color.GREEN);
		viewButton.setBackground(Color.BLACK);
		deleteButton = new JButton("DELETE");
		deleteButton.setForeground(Color.GREEN);
		deleteButton.setBackground(Color.BLACK);
		editButton = new JButton("EDIT");
		editButton.setForeground(Color.GREEN);
		editButton.setBackground(Color.BLACK);
		playButton = new JButton("PLAY");
		playButton.setForeground(Color.GREEN);
		playButton.setBackground(Color.BLACK);
		stopButton = new JButton("STOP");
		stopButton.setForeground(Color.GREEN);
		stopButton.setBackground(Color.BLACK);
		quitButton = new JButton("QUIT");
		quitButton.setForeground(Color.GREEN);
		quitButton.setBackground(Color.BLACK);
		openButton = new JButton("ACTIVATE");
		openButton.setForeground(Color.GREEN);
		openButton.setBackground(Color.BLACK);
		buttonPanel.add(openButton);

		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMusicalizer();
			}
		});
		buttonPanel.add(addButton);
		buttonPanel.add(viewButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(editButton);
		buttonPanel.add(playButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(quitButton);
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 1;
		mainPanel.add(buttonPanel, gbc_buttonPanel);

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMusicToLibrary();
			}
		});

		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewMusicLibrary();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMusic();
			}
		});

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editMusicDetails();
			}
		});

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playMusic();
			}
		});

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopPlaying();
			}
		});

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		pack();
		setVisible(true);
	}

	private void openMusicalizer() {
		outputTextArea.setForeground(Color.GREEN);
		if (!isOpen) {
			isOpen = true;
			outputTextArea.append("Welcome to Musicalizer!\n");

		} else {
			outputTextArea.append("Musicalizer is already open!\n");

		}
	}

	public void addMusicToLibrary() {
		outputTextArea.setForeground(Color.GREEN);
		if (!isOpen) {
			outputTextArea.append("Open Musicalizer first!\n");
			return;
		}

		JTextField titleField = new JTextField();
		titleField.setBackground(Color.BLACK);
		titleField.setForeground(Color.GREEN);

		JTextField genreField = new JTextField();
		genreField.setBackground(Color.BLACK);
		genreField.setForeground(Color.GREEN);

		JTextField artistField = new JTextField();
		artistField.setBackground(Color.BLACK);
		artistField.setForeground(Color.GREEN);

		JTextField lyricsField = new JTextField();
		lyricsField.setBackground(Color.BLACK);
		lyricsField.setForeground(Color.GREEN);

		JTextField bpmField = new JTextField();
		bpmField.setBackground(Color.BLACK);
		bpmField.setForeground(Color.GREEN);

		JTextField timeSignatureField = new JTextField();
		timeSignatureField.setBackground(Color.BLACK);
		timeSignatureField.setForeground(Color.GREEN);

		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("OptionPane.messageForeground", Color.GREEN);

		Object[] message = { "Enter the music title:", titleField, "Enter the music genre:", genreField,
				"Enter the artist:", artistField, "Enter the lyrics:", lyricsField, "Enter the BPM (Beats Per Minute):",
				bpmField, "Enter the time signature (e.g., 4/4):", timeSignatureField };

		JButton okButton = new JButton("OK");
		okButton.setBackground(Color.BLACK);
		okButton.setForeground(Color.GREEN);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.GREEN);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);

		JOptionPane optionPane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION, null,
				new Object[] {}, null);
		optionPane.setOptions(new Object[] { okButton, cancelButton });
		optionPane.setInitialValue(okButton);

		JDialog dialog = optionPane.createDialog(null, "Add Music");
		dialog.getContentPane().setBackground(Color.BLACK);

		okButton.addActionListener(e -> {
			dialog.dispose();

			String title = titleField.getText();
			String genre = genreField.getText();
			String artist = artistField.getText();
			String lyrics = lyricsField.getText();

			int bpm;
			try {
				bpm = Integer.parseInt(bpmField.getText());
			} catch (NumberFormatException ex) {
				outputTextArea.append("Wrong input. Only numbers are allowed for BPM.\n");
				outputTextArea.setForeground(Color.GREEN);
				return;
			}

			String timeSignature = timeSignatureField.getText();
			if (!timeSignature.contains("/")) {
				outputTextArea.append("Invalid time signature. Please provide a valid time signature (e.g., 4/4).\n");
				return;
			}

			Music music = new Music(title, genre, artist, lyrics, bpm, timeSignature);
			musicLibrary.add(music);

			outputTextArea.append("Music added to the library.\n");
		});

		cancelButton.addActionListener(e -> {
			dialog.dispose();
			outputTextArea.append("Adding music canceled.\n");
		});

		dialog.setVisible(true);
	}

	private void viewMusicLibrary() {
		UIManager.put("OptionPane.messageForeground", Color.GREEN);
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.GREEN);
		outputTextArea.setForeground(Color.GREEN);
		outputTextArea.setBackground(Color.BLACK);
		outputTextArea.setCaretColor(Color.GREEN);
		if (!isOpen) {
			outputTextArea.append("Open Musicalizer first!\n");
			return;
		}

		outputTextArea.append("\nMusic Library:\n");

		if (musicLibrary.isEmpty()) {
			outputTextArea.append("The music library is empty.\n");
		} else {
			int i = 1;
			for (Music music : musicLibrary) {
				outputTextArea.append(i + ". Title: " + music.getTitle() + "\n");
				outputTextArea.append("   Genre: " + music.getGenre() + "\n");
				outputTextArea.append("   Artist: " + music.getArtist() + "\n");
				outputTextArea.append("   BPM: " + music.getBpm() + "\n");
				outputTextArea.append("   Time Signature: " + music.getTimeSignature() + "\n");
				outputTextArea.append("   Lyrics: " + music.getLyrics() + "\n");
				i++;
			}
		}
	}

	private void deleteMusic() {
		UIManager.put("OptionPane.messageForeground", Color.GREEN);
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.GREEN);
		outputTextArea.setForeground(Color.GREEN);
		outputTextArea.setBackground(Color.BLACK);
		outputTextArea.setCaretColor(Color.GREEN);
		if (!isOpen) {
			outputTextArea.append("Open Musicalizer first!\n");
			return;
		}

		if (musicLibrary.isEmpty()) {
			outputTextArea.append("There is no music to delete.\n");
			return;
		}

		viewMusicLibrary();

		int choice;
		try {
			choice = Integer.parseInt(JOptionPane.showInputDialog("Choose the music to delete (Enter the number):"));
		} catch (NumberFormatException e) {
			outputTextArea.append("Invalid choice. Please try again.\n");
			return;
		}

		if (choice < 1 || choice > musicLibrary.size()) {
			outputTextArea.append("Invalid choice. Please try again.\n");
			return;
		}

		Music selectedMusic = musicLibrary.get(choice - 1);
		musicLibrary.remove(selectedMusic);
		outputTextArea.append("Music deleted from the library.\n");
	}

	private void editMusicDetails() {
		UIManager.put("OptionPane.messageForeground", Color.GREEN);
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.GREEN);

		if (!isOpen) {
			JOptionPane.showMessageDialog(null, "Open Musicalizer first!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (musicLibrary.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There is no music to edit.", "Information",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		viewMusicLibrary();

		int choice;
		try {
			String choiceString = JOptionPane.showInputDialog(null, "Choose the music to edit (Enter the number):",
					"Edit Music", JOptionPane.PLAIN_MESSAGE);
			choice = Integer.parseInt(choiceString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (choice < 1 || choice > musicLibrary.size()) {
			JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Music selectedMusic = musicLibrary.get(choice - 1);
		String title = JOptionPane.showInputDialog(null, "Enter the new music title:", selectedMusic.getTitle());
		String genre = JOptionPane.showInputDialog(null, "Enter the new music genre:", selectedMusic.getGenre());
		String artist = JOptionPane.showInputDialog(null, "Enter the new artist:", selectedMusic.getArtist());
		String lyrics = JOptionPane.showInputDialog(null, "Enter the new lyrics:", selectedMusic.getLyrics());

		int bpm;
		try {
			String bpmString = JOptionPane.showInputDialog(null, "Enter the new BPM (Beats Per Minute):",
					selectedMusic.getBpm());
			bpm = Integer.parseInt(bpmString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Wrong input. Only numbers are allowed for BPM.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String timeSignature = JOptionPane.showInputDialog(null, "Enter the new time signature (e.g., 4/4):",
				selectedMusic.getTimeSignature());
		if (!timeSignature.contains("/")) {
			JOptionPane.showMessageDialog(null,
					"Invalid time signature. Please provide a valid time signature (e.g., 4/4).", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		selectedMusic.setTitle(title);
		selectedMusic.setGenre(genre);
		selectedMusic.setArtist(artist);
		selectedMusic.setLyrics(lyrics);
		selectedMusic.setBpm(bpm);
		selectedMusic.setTimeSignature(timeSignature);

		JOptionPane.showMessageDialog(null, "Music details updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	private void playMusic() {
		UIManager.put("OptionPane.messageForeground", Color.GREEN);
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.GREEN);
		outputTextArea.setForeground(Color.GREEN);
		outputTextArea.setBackground(Color.BLACK);
		outputTextArea.setCaretColor(Color.GREEN);
		if (!isOpen) {
			outputTextArea.append("Open Musicalizer first!\n");
			return;
		}

		if (musicLibrary.isEmpty()) {
			outputTextArea.append("The music library is empty. Please add music to the library first.\n");
			return;
		}

		viewMusicLibrary();

		int choice;
		try {
			choice = Integer.parseInt(JOptionPane.showInputDialog("Choose the music to play (Enter the number):"));
		} catch (NumberFormatException e) {
			outputTextArea.append("Invalid choice. Please try again.\n");

			outputTextArea.setForeground(Color.GREEN);
			outputTextArea.setBackground(Color.BLACK);
			outputTextArea.setCaretColor(Color.GREEN);
			return;
		}

		if (choice < 1 || choice > musicLibrary.size()) {
			outputTextArea.append("Invalid choice. Please try again.\n");
			return;
		}

		Music selectedMusic = musicLibrary.get(choice - 1);
		outputTextArea.append("\nNow playing: " + selectedMusic.getTitle() + "\n");
		isPlaying = true;
		visualizeLyrics(selectedMusic.getLyrics(), selectedMusic.getBpm(), selectedMusic.getTimeSignature());
	}

	private void stopPlaying() {
		outputTextArea.setForeground(Color.GREEN);
		outputTextArea.setBackground(Color.BLACK);
		outputTextArea.setCaretColor(Color.GREEN);
		if (!isOpen) {
			outputTextArea.append("Open Musicalizer first!\n");
			return;
		}

		if (isPlaying) {
			isPlaying = false;
			outputTextArea.append("\nPlayback stopped.\n");
		} else {
			outputTextArea.append("No music is currently playing.\n");
		}
	}

	private Timer timer;
	private int currentWordIndex;

	private void visualizeLyrics(String lyrics, int bpm, String timeSignature) {
		UIManager.put("OptionPane.messageForeground", Color.GREEN);
		UIManager.put("OptionPane.background", Color.BLACK);
		UIManager.put("Panel.background", Color.BLACK);
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.GREEN);
		outputTextArea.setForeground(Color.GREEN);
		outputTextArea.setBackground(Color.BLACK);
		outputTextArea.setCaretColor(Color.GREEN);
		String[] words = lyrics.split("\\s+");
		double beatDuration = 60.0 / bpm * 1000; // Convert beat duration to milliseconds

		currentWordIndex = 0;

		timer = new Timer((int) beatDuration, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isPlaying) {
					outputTextArea.append("Playback interrupted.\n");
					timer.stop();
					return;
				}

				if (currentWordIndex < words.length) {
					String word = words[currentWordIndex];
					int linesToAdd = (outputTextArea.getHeight() - outputTextArea.getPreferredSize().height)
							/ outputTextArea.getHeight();
					String centeredLyrics = centerText(word, linesToAdd);
					outputTextArea.append(centeredLyrics + "\n");
					currentWordIndex++;
				} else {
					outputTextArea.append("\nPlayback finished.\n");
					timer.stop();
					isPlaying = false;
				}
			}
		});

		timer.setInitialDelay(0);
		timer.start();
	}

	private String centerText(String text, int lines) {
		StringBuilder centeredText = new StringBuilder();
		for (int i = 0; i < lines; i++) {
			centeredText.append("\n");
		}
		centeredText.append(text);
		return centeredText.toString();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OOPGUIFinalProjectMusicalizer();
			}
		});
	}
}

class Music {
	private String title;
	private String genre;
	private String artist;
	private String lyrics;
	private int bpm;
	private String timeSignature;

	public Music(String title, String genre, String artist, String lyrics, int bpm, String timeSignature) {
		this.title = title;
		this.genre = genre;
		this.artist = artist;
		this.lyrics = lyrics;
		this.bpm = bpm;
		this.timeSignature = timeSignature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public String getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(String timeSignature) {
		this.timeSignature = timeSignature;
	}
}
