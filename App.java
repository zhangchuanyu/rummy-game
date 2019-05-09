package com.rummyGame;

import java.util.ArrayList;

import java.util.List;

import javafx.util.Duration;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.application.Platform;

public class App extends Application {

	Button continueButton = new Button("Continue");
	Button quitButton = new Button("Quit");
	Button gameRiggingButton= new Button("Game Rigging");
	
	String theTurn= " ";
	Button drawRigging= new Button("Draw Rigging");
	ComboBox cBox;
	Text textAI = new Text();
	String value;
	Text text = new Text();

	Text text2 = new Text();
	Stage currentStage;
	GameGUI game;
	List<Tile> humanHand = new ArrayList<>();
	TilePane humanHandBox;
	TilePane theHumanHandBox1;
	TilePane theHumanHandBox2;
	TilePane theHumanHandBox3;



	TilePane humanHandBox2;
	TilePane humanHandBox3;
	TilePane humanHandBox4;
	TilePane humanHandBox5;

	TilePane AIPlayerHandBox;
	TilePane AIPlayerHandBox2;
	TilePane AIPlayerHandBox3;


	HBox hBox2 = new HBox();
	HBox hBox3 = new HBox();
	HBox UIPlayerPlayingFunction;

	TilePane tableBox;
	HBox pBox;
	
	Label labelHuman;
	Label deckNumberLabel;
	Label label;
	Label label2;
	Label label3;
	Label label4;
	Label label5;
	Label label6;

	// for UI
	int playerHumanPlayMelds = 0;
	int humanPlayerFirstTurn = 1;

	// for saving table use detail
	int theTableIndex[] = new int[100];

	int numOfTableIndex = 0;

	ComboBox cBox5 = new ComboBox();

	// For Timer
	Timeline updateTimer = new Timeline();
	
	final static int TIMEOUT_SECONDS=120;
	private int totalTime = TIMEOUT_SECONDS;
	
	//For game rigging
	TilePane deck;
	Label humanPlayerLabel;
	Label humanPlayerLabel1;
	Label humanPlayerLabel2;
	Label humanPlayerLabel3;



	Label labelAIPlayer1;
	Label labelAIPlayer2;
	Label labelAIPlayer3;
	Label labelTable;


	public void chooseYourComponentSceen(int numPlayers) {
		Button tieBreakerButton= new Button("Tie Breaker Option");
		Pane aPane = new Pane();
		VBox vBox2 = new VBox();
		vBox2.setSpacing(20);
		hBox3.setSpacing(20);
		Button continue2Button = new Button("Play with normal");
		continue2Button.setPrefSize(200, 100);

		ComboBox cBox2 = new ComboBox();

		if (numPlayers == 2) {
			text2.setText("Choose your component? AI or Human Player.");
			cBox2.getItems().add("Human Player");
			cBox2.getItems().add("AI player strategy 1");
			cBox2.getItems().add("AI player strategy 2");
			cBox2.getItems().add("AI player strategy 3");

			cBox2.getSelectionModel().select(3);
		}
		if (numPlayers == 3) {
			text2.setText("Choose your component? AI or Human Player.");
			cBox2.getItems().add("Human Player and AI player strategy 1");
			cBox2.getItems().add("Human Player and AI player strategy 2");
			cBox2.getItems().add("Human Player and AI player strategy 3");
			cBox2.getItems().add("AI player strategy 1 and AI player strategy 2");
			cBox2.getItems().add("AI player strategy 1 and AI player strategy 3");
			cBox2.getItems().add("AI player strategy 2 and AI player strategy 3");

			cBox2.getSelectionModel().select(5);

		}
		if (numPlayers == 4) {
			text2.setText("Choose your component? AI or Human Player.");
			cBox2.getItems().add("Three of Human Player");
			cBox2.getItems().add("Two of Human Player and AI player strategy 1");
			cBox2.getItems().add("Two of Human Player and AI player strategy 2");
			cBox2.getItems().add("Two of Human Player and AI player strategy 3");
			cBox2.getItems().add("One Human Player with AI player strategy 1 and AI player strategy 2");
			cBox2.getItems().add("One Human Player with AI player strategy 1 and AI player strategy 3");
			cBox2.getItems().add("One Human Player with AI player strategy 2 and AI player strategy 3");
			cBox2.getItems().add("Three of AI player");

			cBox2.getSelectionModel().select(7);

		}

		gameRiggingButton.setPrefSize(200, 100);
		gameRiggingButton.setStyle("-fx-font: 20 arial; -fx-base: rgb(163,81,223); " + "-fx-text-fill: rgb(174,151,194);");
		
		tieBreakerButton.setPrefSize(200, 100);
		tieBreakerButton.setStyle("-fx-font: 20 arial; -fx-base: rgb(163,81,223); " + "-fx-text-fill: rgb(174,151,194);");
		
		hBox2.setAlignment(Pos.CENTER);
		hBox2.getChildren().add(text2);
		hBox2.getChildren().add(cBox2);

		hBox3.getChildren().add(continue2Button);
		hBox3.getChildren().add(gameRiggingButton);
		hBox3.getChildren().add(tieBreakerButton);



		vBox2.setAlignment(Pos.CENTER);
		vBox2.getChildren().add(hBox2);
		vBox2.getChildren().add(hBox3);

		aPane.getChildren().addAll(vBox2);
		currentStage.setScene(new Scene(aPane, 1200, 800));
		currentStage.show();

		continue2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				chooseTurn(numPlayers, cBox2.getValue().toString(),1);

			}
		});
		gameRiggingButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameRiggingScene(numPlayers,cBox2.getValue().toString(),2);
			}
		});
		tieBreakerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		});

	}
	public void tieBreakerScene(String s,int numPlayers)
	{
		game=new GameGUI(" ");
		Pane aPane = new Pane();
		VBox vBox2 = new VBox();
		HBox h1= new HBox();
		HBox h2= new HBox();


		vBox2.setSpacing(20);
		h1.setSpacing(20);
		Button theDraw= new Button("Draw To determine who starts");
		theDraw.setPrefSize(200, 100);
		theDraw.setStyle("-fx-font: 20 arial; -fx-base: rgb(163,81,223); " + "-fx-text-fill: rgb(174,151,194);");
		h1.getChildren().add(theDraw);
		vBox2.getChildren().add(h1);
		aPane.getChildren().addAll(vBox2);
		currentStage.setScene(new Scene(aPane, 1200, 800));
		currentStage.show();
		
		theDraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Button theContinue1= new Button("Start Game");
				if(s.equals("AI player strategy 1"))
				{
					game.getTieHumanPlayer().draw(game.getTieDeck().myNextTiles());
					game.getTieAIPlayer1().draw(game.getTieDeck().myNextTiles());
					
					
					while(game.getTieHumanPlayer().theTiles()[0].getValue()==game.getTieAIPlayer1().theTiles()[0].getValue())
					{
						
						game.getTieHumanPlayer().draw(game.getTieDeck().myNextTiles());
						game.getTieAIPlayer1().draw(game.getTieDeck().myNextTiles());
						
					}
					

				}
				theContinue1.setPrefSize(200, 100);
				theContinue1.setStyle("-fx-font: 20 arial; -fx-base: rgb(163,81,223); " + "-fx-text-fill: rgb(174,151,194);");
				h1.getChildren().add(theContinue1);
				
				theContinue1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) 
					{
						if(game.getTieHumanPlayer().theTiles()[0].getValue()>game.getTieAIPlayer1().theTiles()[0].getValue())
						{
							game.getTieAIPlayer1().printTiles();
							game.getTieHumanPlayer().printTiles();
							theTurn = "Yourself(1), AI player strategy 1 (2)";
							game.init();
							game.getHumanPlayer(1).printTiles();
							game.getAIPlayer(1).printTiles();
							showMainScene(1,s);
							updateTimer.play();

						}
						else if(game.getTieAIPlayer1().theTiles()[0].getValue()>game.getTieHumanPlayer().theTiles()[0].getValue())
						{
							game.getTieAIPlayer1().printTiles();
							game.getTieHumanPlayer().printTiles();
							theTurn = "AI player strategy 1 (1), Yourself (2)";
							game.setPlayerTurn(theTurn);
							game.init();
							game.getHumanPlayer(1).printTiles();
							game.getAIPlayer(1).printTiles();
							game.AIplayer1Play();
							showMainScene(1,s);
							updateTimer.play();


						}
					}
				});
			}
		});

	}
	public void gameRiggingScene(int numPlayers,String s,int choice)
	{
		game= new GameGUI(" ");
		Pane aPane = new Pane();
		continueButton.setPrefSize(100, 100);

		TilePane newTilePane= new TilePane();
		newTilePane.setHgap(10);
		VBox deckBox= new VBox();
		humanPlayerLabel= new Label();
		humanPlayerLabel1= new Label();
		humanPlayerLabel2= new Label();
		humanPlayerLabel3= new Label();



		labelAIPlayer1= new Label();
		labelAIPlayer2= new Label();
		labelAIPlayer3= new Label();

		deckBox.setPrefWidth(1200);
		deckBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		deck= new TilePane();
		deck.setPrefHeight(200);
		deck.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		deck.setVgap(10);
		deck.setHgap(1);
		
		humanHandBox = new TilePane();
		humanHandBox.setPrefHeight(100);
		humanHandBox.setHgap(5);
		humanHandBox.setVgap(5);
		humanHandBox.setAlignment(Pos.CENTER);
		
		AIPlayerHandBox= new TilePane();
		AIPlayerHandBox.setPrefHeight(100);
		AIPlayerHandBox.setHgap(5);
		AIPlayerHandBox.setVgap(5);
		AIPlayerHandBox.setAlignment(Pos.CENTER);
		
		humanPlayerLabel.setText("Choose initial tiles for Yourself");
		humanPlayerLabel.setFont(new Font(18));
		humanPlayerLabel.setStyle("-fx-border-color: black");

		humanPlayerLabel1.setText("Choose initial tiles for Human Player 1");
		humanPlayerLabel1.setFont(new Font(18));
		humanPlayerLabel1.setStyle("-fx-border-color: black");
		
		humanPlayerLabel2.setText("Choose initial tiles for Human Player 2");
		humanPlayerLabel2.setFont(new Font(18));
		humanPlayerLabel2.setStyle("-fx-border-color: black");
		
		humanPlayerLabel3.setText("Choose initial tiles for Human Player 3");
		humanPlayerLabel3.setFont(new Font(18));
		humanPlayerLabel3.setStyle("-fx-border-color: black");

		labelAIPlayer1.setText("choose initial tiles for AI Player 1");
		labelAIPlayer1.setFont(new Font(18));
		labelAIPlayer1.setStyle("-fx-border-color: black");

		labelAIPlayer2.setText("choose initial tiles for AI Player 2");
		labelAIPlayer2.setFont(new Font(18));
		labelAIPlayer2.setStyle("-fx-border-color: black");

		labelAIPlayer3.setText("choose initial tiles for AI Player 3");
		labelAIPlayer3.setFont(new Font(18));
		labelAIPlayer3.setStyle("-fx-border-color: black");

		int turn=1;

		
		if (s.equals("Human Player")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					humanHandBox.getChildren().clear();

						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								tableRiggingScreen(numPlayers, s, choice);						
							}
						});
				}
			});
		}
		if (s.equals("AI player strategy 1")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					humanHandBox.getChildren().clear();

						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(1);
						newTilePane.getChildren().add(labelAIPlayer1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								tableRiggingScreen(numPlayers, s, choice);						
							}
						});
				}
			});
		}
		if (s.equals("AI player strategy 2")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(2);
						newTilePane.getChildren().add(labelAIPlayer2);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								tableRiggingScreen(numPlayers, s, choice);						
							}
						});
				}
			});
		}
		if (s.equals("AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(3);
						newTilePane.getChildren().add(labelAIPlayer3);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								tableRiggingScreen(numPlayers, s, choice);						
							}
						});
				}
			});
		}
		if (s.equals("AI player strategy 1 and AI player strategy 2")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(1);
						newTilePane.getChildren().add(labelAIPlayer1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(2);
								newTilePane.getChildren().add(labelAIPlayer2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										tableRiggingScreen(numPlayers, s, choice);						
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("AI player strategy 1 and AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(1);
						newTilePane.getChildren().add(labelAIPlayer1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(3);
								newTilePane.getChildren().add(labelAIPlayer3);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										tableRiggingScreen(numPlayers, s, choice);						
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("AI player strategy 2 and AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(2);
						newTilePane.getChildren().add(labelAIPlayer2);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(3);
								newTilePane.getChildren().add(labelAIPlayer3);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										tableRiggingScreen(numPlayers, s, choice);						
									}
								});						
							}
						});
				}
			});
		}
		
		if (s.equals("Human Player and AI player strategy 1")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(1);
								newTilePane.getChildren().add(labelAIPlayer1);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										tableRiggingScreen(numPlayers, s, choice);						
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("Human Player and AI player strategy 2")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(2);
								newTilePane.getChildren().add(labelAIPlayer2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										tableRiggingScreen(numPlayers, s, choice);						
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("Human Player and AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								humanHandBox.getChildren().clear();
								newTilePane.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(3);
								newTilePane.getChildren().add(labelAIPlayer3);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										tableRiggingScreen(numPlayers, s, choice);						
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("Two of Human Player and AI player strategy 1")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(6);
								newTilePane.getChildren().add(humanPlayerLabel2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										humanHandBox.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(1);
										newTilePane.getChildren().add(labelAIPlayer1);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("Two of Human Player and AI player strategy 2")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(6);
								newTilePane.getChildren().add(humanPlayerLabel2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										humanHandBox.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(2);
										newTilePane.getChildren().add(labelAIPlayer2);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("Two of Human Player and AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(6);
								newTilePane.getChildren().add(humanPlayerLabel2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										humanHandBox.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(3);
										newTilePane.getChildren().add(labelAIPlayer3);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 2")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(1);
								newTilePane.getChildren().add(labelAIPlayer1);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										humanHandBox.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(2);
										newTilePane.getChildren().add(labelAIPlayer2);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(1);
								newTilePane.getChildren().add(labelAIPlayer1);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										humanHandBox.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(3);
										newTilePane.getChildren().add(labelAIPlayer3);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("One Human Player with AI player strategy 2 and AI player strategy 3")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								humanHandBox.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(2);
								newTilePane.getChildren().add(labelAIPlayer2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										humanHandBox.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(3);
										newTilePane.getChildren().add(labelAIPlayer3);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		if (s.equals("Three of AI player")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(1);
						newTilePane.getChildren().add(labelAIPlayer1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								newTilePane.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(2);
								newTilePane.getChildren().add(labelAIPlayer2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										newTilePane.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(3);
										newTilePane.getChildren().add(labelAIPlayer3);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}

		if (s.equals("Three of Human Player")) 
		{
			Button continueButton3= new Button("Continue");
			newTilePane.getChildren().clear();
			showDeck(0);
			newTilePane.getChildren().add(humanPlayerLabel);
			newTilePane.getChildren().add(continueButton3);
			
			continueButton3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().clear();
						newTilePane.getChildren().clear();
						Button continueButton4= new Button("Continue");
						showDeck(5);
						newTilePane.getChildren().add(humanPlayerLabel1);
						newTilePane.getChildren().add(continueButton4);
						
						continueButton4.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								humanHandBox.getChildren().clear();
								newTilePane.getChildren().clear();
								Button continueButton5= new Button("Continue");
								showDeck(6);
								newTilePane.getChildren().add(humanPlayerLabel2);
								newTilePane.getChildren().add(continueButton5);
								
								continueButton5.setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										humanHandBox.getChildren().clear();
										newTilePane.getChildren().clear();
										Button continueButton6= new Button("Continue");
										showDeck(7);
										newTilePane.getChildren().add(humanPlayerLabel3);
										newTilePane.getChildren().add(continueButton6);
										
										continueButton6.setOnAction(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												tableRiggingScreen(numPlayers, s, choice);						
											}
										});								
									}
								});						
							}
						});
				}
			});
		}
		deckBox.getChildren().add(deck);
		deckBox.getChildren().add(humanHandBox);
		deckBox.getChildren().add(AIPlayerHandBox);

		deckBox.getChildren().add(newTilePane);

	

		aPane.getChildren().addAll(deckBox);
		currentStage.setScene(new Scene(aPane, 1200, 800));
		currentStage.show();
		
	}

	public void tableRiggingScreen(int numPlayers, String s,int choice)
	{
		Pane aPane = new Pane();
		Button continueButton3= new Button("Continue");

		Button buttonBuildMeld = new Button("Build Meld");

		TilePane newTilePane= new TilePane();
		VBox deckBox= new VBox();
		labelTable= new Label();
		
		deckBox.setPrefWidth(1200);
		deckBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		deck= new TilePane();
		deck.setPrefHeight(200);
		deck.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		deck.setVgap(10);
		deck.setHgap(1);
		

		labelTable.setText("Choose initial tiles in table");
		labelTable.setFont(new Font(18));
		labelTable.setStyle("-fx-border-color: black");
		showDeck(4);
		
		tableBox = new TilePane();
		tableBox.prefHeight(200);
		tableBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		tableBox.setHgap(20);
		tableBox.setVgap(20);
		
		showTable(1);
		
		newTilePane.getChildren().add(labelTable);
		newTilePane.getChildren().add(buttonBuildMeld);
		newTilePane.getChildren().add(continueButton3);

		deckBox.getChildren().add(deck);
		deckBox.getChildren().add(tableBox);
		deckBox.getChildren().add(newTilePane);

	

		aPane.getChildren().addAll(deckBox);
		currentStage.setScene(new Scene(aPane, 1200, 900));
		currentStage.show();
		continueButton3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				chooseTurn(numPlayers,s,choice);
			

			}
		});
		buttonBuildMeld.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gameRiggingIntoTable(game.getTable()[game.getTableIndex()]);
				showTable(1);
			}
		});
	}
	public void chooseTurn(int numPlayers, String s,int choice) {
		Pane aPane = new Pane();
		Text text3 = new Text();
		VBox vBox2 = new VBox();
		HBox hBox4 = new HBox();
		HBox hBox5 = new HBox();
		hBox5.setSpacing(20);
		vBox2.setSpacing(20);
		Button startButton = new Button("Start Game");
		startButton.setPrefSize(100, 100);
		

		if (s.equals("Human Player")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), Human Player(2)");
			cBox5.getItems().add("Human Player(1), Yourself(2)");
			cBox5.getSelectionModel().select(1);

		}
		if (s.equals("AI player strategy 1")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2)");
			cBox5.getItems().add("AI player strategy 1 (1), Yourself (2)");
			cBox5.getSelectionModel().select(1);

		}
		if (s.equals("AI player strategy 2")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2)");
			cBox5.getItems().add("AI player strategy 2 (1), Yourself (2)");
			cBox5.getSelectionModel().select(1);

		}
		if (s.equals("AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2)");
			cBox5.getItems().add("AI player strategy 3 (1), Yourself (2)");
			cBox5.getSelectionModel().select(1);

		}
		if (s.equals("Human Player and AI player strategy 1")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), Human Player (2), AI player strategy 1 (3)");
			cBox5.getItems().add("Human Player(1), Yourself(2), AI player strategy 1 (3)");
			cBox5.getItems().add("AI player strategy 1 (1), Yourself(2), Human Player (3)");
			cBox5.getItems().add("Yourself (1), AI player strategy 1 (2), Human Player (3)");
			cBox5.getItems().add("AI player strategy 1 (1), Human Player (2), Yourself (3)");
			cBox5.getItems().add("Human Player (1), AI player strategy 1 (2), Yourself (3)");

			cBox5.getSelectionModel().select(5);

		}
		if (s.equals("Human Player and AI player strategy 2")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), Human Player (2), AI player strategy 2 (3)");
			cBox5.getItems().add("Human Player(1), Yourself(2), AI player strategy 2 (3)");
			cBox5.getItems().add("AI player strategy 2 (1), Yourself(2), Human Player (3)");
			cBox5.getItems().add("Yourself (1), AI player strategy 2 (2), Human Player (3)");
			cBox5.getItems().add("AI player strategy 2 (1), Human Player (2), Yourself (3)");
			cBox5.getItems().add("Human Player (1), AI player strategy 2 (2), Yourself (3)");

			cBox5.getSelectionModel().select(5);

		}
		if (s.equals("Human Player and AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), Human Player (2), AI player strategy 3 (3)");
			cBox5.getItems().add("Human Player(1), Yourself(2), AI player strategy 3 (3)");
			cBox5.getItems().add("AI player strategy 3 (1), Yourself(2), Human Player (3)");
			cBox5.getItems().add("Yourself (1), AI player strategy 3 (2), Human Player (3)");
			cBox5.getItems().add("AI player strategy 3 (1), Human Player (2), Yourself (3)");
			cBox5.getItems().add("Human Player (1), AI player strategy 3 (2), Yourself (3)");

			cBox5.getSelectionModel().select(5);
		}
		if (s.equals("AI player strategy 1 and AI player strategy 2")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3)");
			cBox5.getItems().add("AI player strategy 1(1), Yourself(2), AI player strategy 2 (3)");
			cBox5.getItems().add("AI player strategy 2(1), Yourself(2), AI player strategy 1 (3)");
			cBox5.getItems().add("Yourself (1), AI player strategy 2 (2), AI player strategy 1 (3)");
			cBox5.getItems().add("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3)");
			cBox5.getItems().add("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3)");

			cBox5.getSelectionModel().select(5);
		}
		if (s.equals("AI player strategy 1 and AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3)");
			cBox5.getItems().add("AI player strategy 1(1), Yourself(2), AI player strategy 3 (3)");
			cBox5.getItems().add("AI player strategy 3(1), Yourself(2), AI player strategy 1 (3)");
			cBox5.getItems().add("Yourself (1), AI player strategy 3 (2), AI player strategy 1 (3)");
			cBox5.getItems().add("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3)");
			cBox5.getItems().add("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3)");

			cBox5.getSelectionModel().select(5);

		}
		if (s.equals("AI player strategy 2 and AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3)");
			cBox5.getItems().add("AI player strategy 2(1), Yourself(2), AI player strategy 3 (3)");
			cBox5.getItems().add("AI player strategy 3(1), Yourself(2), AI player strategy 2 (3)");
			cBox5.getItems().add("Yourself (1), AI player strategy 3 (2), AI player strategy 2 (3)");
			cBox5.getItems().add("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3)");
			cBox5.getItems().add("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3)");

			cBox5.getSelectionModel().select(5);
		}
		if (s.equals("Three of AI player")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems()
					.add("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), AI player strategy 1 (4)");

			cBox5.getItems()
					.add("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)");

			cBox5.getItems()
					.add("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)");

			cBox5.getSelectionModel().select(23);
		}
		if (s.equals("Two of Human Player and AI player strategy 1")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), AI player strategy 1 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 1 (4)");

			cBox5.getItems().add("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("AI player strategy 1 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)");
			cBox5.getItems().add("AI player strategy 1 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("AI player strategy 1 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems().add("AI player strategy 1 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems().add("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), AI player strategy 1 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Human Player 1 (1), AI player strategy 1 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), Human Player 2 (4)");

			cBox5.getItems().add("Human Player 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)");

			cBox5.getSelectionModel().select(23);

		}
		if (s.equals("Two of Human Player and AI player strategy 2")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), AI player strategy 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 2 (4)");

			cBox5.getItems().add("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("AI player strategy 2 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)");
			cBox5.getItems().add("AI player strategy 2 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("AI player strategy 2 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems().add("AI player strategy 2 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems().add("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), AI player strategy 2 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 2 (4)");

			cBox5.getItems().add("Human Player 2 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Human Player 2 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)");

			cBox5.getSelectionModel().select(23);
		}
		if (s.equals("Two of Human Player and AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), AI player strategy 3 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 3 (4)");

			cBox5.getItems().add("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("AI player strategy 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)");
			cBox5.getItems().add("AI player strategy 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("AI player strategy 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems().add("AI player strategy 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems().add("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Human Player 1 (1), AI player strategy 3 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 2 (4)");

			cBox5.getItems().add("Human Player 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Human Player 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)");

			cBox5.getSelectionModel().select(23);
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 2")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), Human Player 1 (4)");

			cBox5.getItems()
					.add("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)");

			cBox5.getSelectionModel().select(23);

		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 1 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), Human Player 1 (4)");

			cBox5.getItems()
					.add("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 1 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)");

			cBox5.getSelectionModel().select(23);

		}
		if (s.equals("One Human Player with AI player strategy 2 and AI player strategy 3")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 3 (4)");
			cBox5.getItems().add("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), Human Player 1 (4)");

			cBox5.getItems()
					.add("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 3 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems()
					.add("AI player strategy 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems()
					.add("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)");
			cBox5.getItems()
					.add("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)");

			cBox5.getSelectionModel().select(23);

		}
		if (s.equals("Three of Human Player")) {
			text3.setText("Determine who starts as per rules");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), Human Player 2 (3), Human Player 3 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 1 (2), Human Player 3 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), Human Player 1 (3), Human Player 3 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 2 (2), Human Player 3 (3), Human Player 1 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 3 (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Yourself(1), Human Player 3 (2), Human Player 2 (3), Human Player 1 (4)");

			cBox5.getItems().add("Human Player 1 (1), Yourself (2), Human Player 2 (3), Human Player 3 (4)");
			cBox5.getItems().add("Human Player 1 (1), Yourself (2), Human Player 3 (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), Yourself (3), Human Player 3 (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 2 (2), Human Player 3 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 3 (2), Yourself (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 1 (1), Human Player 3 (2), Human Player 2 (3), Yourself (4)");

			cBox5.getItems().add("Human Player 2 (1), Yourself (2), Human Player 1 (3), Human Player 3 (4)");
			cBox5.getItems().add("Human Player 2 (1), Yourself (2), Human Player 3 (3), Human Player 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), Yourself (3), Human Player 3 (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 1 (2), Human Player 3 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 3 (2), Yourself (3), Human Player 1 (4)");
			cBox5.getItems().add("Human Player 2 (1), Human Player 3 (2), Human Player 1 (3), Yourself (4)");

			cBox5.getItems().add("Human Player 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)");
			cBox5.getItems().add("Human Player 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)");
			cBox5.getItems().add("Human Player 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)");
			cBox5.getItems().add("Human Player 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)");

			cBox5.getSelectionModel().select(23);
		}

		hBox4.setAlignment(Pos.CENTER);
		hBox4.getChildren().add(text3);
		hBox4.getChildren().add(cBox5);

		hBox5.getChildren().add(startButton);
		vBox2.setAlignment(Pos.CENTER);
		vBox2.getChildren().add(hBox4);
		vBox2.getChildren().add(hBox5);

		aPane.getChildren().addAll(vBox2);
		currentStage.setScene(new Scene(aPane, 1200, 800));
		currentStage.show();

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				startGame(choice,s);
			}
		});
	
	}

		private void startGame(int number,String s) {

		if(number==1)
		{
		game = new GameGUI(cBox5.getValue().toString());
		game.init();
		}
		
		//Three UI Player 
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), Human Player 3 (4)")
				|| cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 3 (3), Human Player 2 (4)")
				|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), Human Player 3 (4)")
				|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 3 (3), Human Player 1 (4)")
				|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 1 (3), Human Player 2 (4)")
				|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 2 (3), Human Player 1 (4)")) 
		{
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), Human Player 3 (4)")
				|| cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 3 (3), Human Player 2 (4)")
				|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), Human Player 3 (4)")
				|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Human Player 3 (3), Yourself (4)")
				|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Yourself (3), Human Player 2 (4)")
				|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Human Player 2 (3), Yourself (4)")) 
		{
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), Human Player 3 (4)")
				|| cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 3 (3), Human Player 1 (4)")
				|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), Human Player 3 (4)")
				|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Human Player 3 (3), Yourself (4)")
				|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Yourself (3), Human Player 1 (4)")
				|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Human Player 1 (3), Yourself (4)")) 
		{
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")
				|| cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")
				|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")
				|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")
				|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")
				|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) 
		{
			showMainScene(1,s);
			updateTimer.play();
		}
		
		//Two human and AI strategy 1
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), Human Player 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 2 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), Human Player 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer1Play();
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer1Play();
			showMainScene(3,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), Human Player 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 1 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 1 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 1 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Human Player 2 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), Human Player 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		
		//Two human and strategy 2 
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), Human Player 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 2 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), Human Player 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer2Play();
			showMainScene(3,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 2 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Human Player 2 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		
		//doing two human player and AI strategy 3
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), Human Player 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 2 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), Human Player 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer3Play();
			showMainScene(3,s);
			updateTimer.play();
		}
		
		
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 3 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 3 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 3 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Human Player 2 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
			showMainScene(3,s);
			updateTimer.play();
		}
		
		//One human and AI 1 and AI 2
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		
		
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		
		//One human player and AI 1 and AI 3
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		
		
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		
		
		//One human Player and AI 2 and AI 3
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
			game.AIplayer2Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			showMainScene(2,s);
			updateTimer.play();
		}

		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)")) {
			showMainScene(2,s);
			updateTimer.play();
		}

		
		//doing human Player and AI strategy 1
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 1 (3)")) {
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 1 (3)")) {
			showMainScene(2,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself(2), Human Player (3)")) {

			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 1 (2), Human Player (3)")) {

			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player (2), Yourself (3)")) {

			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 1 (2), Yourself (3)")) {

			showMainScene(2,s);
			updateTimer.play();
		}
		//doing humanPlayer and AI player2 
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 2 (3)")) {
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 2 (3)")) {
			showMainScene(2,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself(2), Human Player (3)")) {

			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 2 (2), Human Player (3)")) {

			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player (2), Yourself (3)")) {

			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 2 (2), Yourself (3)")) {

			showMainScene(2,s);
			updateTimer.play();
		}
		
		//doing human Player and AI player 3
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 3 (3)")) {
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 3 (3)")) {
			showMainScene(2,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself(2), Human Player (3)")) {

			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), Human Player (3)")) {

			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player (2), Yourself (3)")) {

			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 3 (2), Yourself (3)")) {

			showMainScene(2,s);
			updateTimer.play();
		}
		//
		if (cBox5.getValue().toString().equals("Yourself(1), Human Player(2)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2)")) {
			game.AIplayer1Play();
			showMainScene(2,s);
			updateTimer.play();

		}
		
		
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();

		}

		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 2 (2), AI player strategy 1 (3)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 1(1), Yourself(2), AI player strategy 2 (3)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 2(1), Yourself(2), AI player strategy 1 (3)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();

		}

		
		
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), AI player strategy 1 (3)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		
		if (cBox5.getValue().toString().equals("AI player strategy 1(1), Yourself(2), AI player strategy 3 (3)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3(1), Yourself(2), AI player strategy 1 (3)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}

		// component is AI player 2 and AI player 3
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), AI player strategy 2 (3)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2(1), Yourself(2), AI player strategy 3 (3)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3(1), Yourself(2), AI player strategy 2 (3)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}

		// component with three of AI players
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}

		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}

		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
			game.AIplayer3Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			game.AIplayer1Play();
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
			showMainScene(1,s);
			updateTimer.play();
		}


		

	}


	private void playWithAIPlayer() {
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2)")) {
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2)")) {
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2)")) {
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2)")) {
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2)")) {
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2)")) {
			game.AIplayer3Play();
		}

		// component is AI Player1 and AI player2
		if (cBox5.getValue().toString().equals("AI player strategy 1(1), Yourself(2), AI player strategy 2 (3)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 2(1), Yourself(2), AI player strategy 1 (3)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();

		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
		}

		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 2 (2), AI player strategy 1 (3)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
		}

		// component is AI player 1 and AI player 3
		if (cBox5.getValue().toString().equals("AI player strategy 1(1), Yourself(2), AI player strategy 3 (3)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3(1), Yourself(2), AI player strategy 1 (3)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), AI player strategy 1 (3)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
		}

		// component is AI player 2 and AI player 3
		if (cBox5.getValue().toString().equals("AI player strategy 2(1), Yourself(2), AI player strategy 3 (3)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3(1), Yourself(2), AI player strategy 2 (3)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), AI player strategy 2 (3)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
		}

		// component with three of AI players
		if (cBox5.getValue().toString()
				.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			game.AIplayer3Play();

		}
		if (cBox5.getValue().toString()
				.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			game.AIplayer2Play();

		}
		if (cBox5.getValue().toString()
				.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			game.AIplayer3Play();

		}
		if (cBox5.getValue().toString()
				.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			game.AIplayer1Play();

		}
		if (cBox5.getValue().toString()
				.equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			game.AIplayer2Play();

		}
		if (cBox5.getValue().toString()
				.equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			game.AIplayer1Play();

		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			game.AIplayer1Play();

		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			game.AIplayer2Play();
		}

		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 2 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			game.AIplayer1Play();
		}

		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
			game.AIplayer1Play();
			game.AIplayer2Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
			game.AIplayer2Play();
			game.AIplayer1Play();
			game.AIplayer3Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)")) {
			game.AIplayer2Play();
			game.AIplayer3Play();
			game.AIplayer1Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)")) {
			game.AIplayer3Play();
			game.AIplayer1Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)")) {
			game.AIplayer1Play();
			game.AIplayer3Play();
			game.AIplayer2Play();
		}
		if (cBox5.getValue().toString()
				.equals("AI player strategy 3 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)")) {
			game.AIplayer3Play();
			game.AIplayer2Play();
			game.AIplayer1Play();
		}

	}

	private Color getTextColor(TileColor tileColor) {
		switch (tileColor) {
		case Red:
			return Color.RED;
		case Green:
			return Color.GREEN;
		case Orange:
			return Color.ORANGE;
		case Blue:
			return Color.BLUE;
		}

		return Color.BLACK;
	}

	private void redrawHumanHand() {

	}

	private void showMainScene(int human,String s) {
		Pane aPane = new Pane();
		VBox mainBox = new VBox();
		deckNumberLabel = new Label();
		label = new Label();
		label2 = new Label();
		label3 = new Label();
		label4 = new Label();
		label5 = new Label();
		label6 = new Label();
		
		labelHuman= new Label();
		pBox= new HBox(); 
		pBox.setSpacing(30);

		mainBox.setSpacing(20);
		mainBox.setPrefWidth(1400);
		mainBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

		UIPlayerPlayingFunction = new HBox();
		UIPlayerPlayingFunction.setSpacing(20);

		Button button789 = new Button("789");
		Button button777 = new Button("777");
		Button buttonDraw = new Button("DRAW");
		Button buttonBuildMeld = new Button("Build Meld");
		Button buttonDone = new Button("DONE");
		Button buttonP= new Button("P");

		tableBox = new TilePane();
		tableBox.setPrefHeight(200);
		tableBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		tableBox.setHgap(20);
		tableBox.setVgap(20);

		deck= new TilePane();
		
		humanHandBox = new TilePane();
		humanHandBox.setHgap(5);
		humanHandBox.setVgap(5);
		humanHandBox.setAlignment(Pos.CENTER);

		humanHandBox2 = new TilePane();
		humanHandBox2.setHgap(5);
		humanHandBox2.setVgap(5);
		humanHandBox2.setAlignment(Pos.CENTER);

		humanHandBox3 = new TilePane();
		humanHandBox3.setHgap(1);
		humanHandBox3.setVgap(1);
		humanHandBox3.setAlignment(Pos.CENTER);

		humanHandBox4 = new TilePane();
		humanHandBox4.setHgap(1);
		humanHandBox4.setVgap(1);
		humanHandBox4.setAlignment(Pos.CENTER);

		humanHandBox5 = new TilePane();
		humanHandBox5.setHgap(1);
		humanHandBox5.setVgap(1);
		humanHandBox5.setAlignment(Pos.CENTER);
		Tile[] tiles = game.getHumanPlayer(human).theTiles();

		showHandTiles(human);

		showTable(human);

		TextField textField = new TextField();
		createTimer(textField,human,s);
		textField.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(textField);

		button789.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(button789);

		button777.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(button777);

		buttonDraw.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(buttonDraw);

		buttonBuildMeld.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(buttonBuildMeld);
		
		buttonP.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(buttonP);
		
		

		buttonDone.setPrefSize(100, 100);
		UIPlayerPlayingFunction.setAlignment(Pos.BOTTOM_CENTER);
		UIPlayerPlayingFunction.getChildren().add(buttonDone);

		
		UIPlayerPlayingFunction.getChildren().remove(deckNumberLabel);
		deckNumberLabel.setText("Remaining Tiles from deck :" + game.getDeck().theNumOfTiles());
		deckNumberLabel.setFont(new Font(18));
		deckNumberLabel.setStyle("-fx-border-color: black");
		UIPlayerPlayingFunction.getChildren().add(deckNumberLabel);

		
		UIPlayerPlayingFunction.getChildren().remove(labelHuman);

		if(human==1)
		{
		labelHuman.setText("Yourself is playing  :" );
		labelHuman.setFont(new Font(18));
		labelHuman.setStyle("-fx-border-color: black");
		}
		if(human==2)
		{
		labelHuman.setText("Human Player 1 is playing  :" );
		labelHuman.setFont(new Font(18));
		labelHuman.setStyle("-fx-border-color: black");
		}
		if(human==3)
		{
		labelHuman.setText("Human Player 2 is playing  :" );
		labelHuman.setFont(new Font(18));
		labelHuman.setStyle("-fx-border-color: black");
		}
		if(human==4)
		{
		labelHuman.setText("Human Player 3 is playing  :" );
		labelHuman.setFont(new Font(18));
		labelHuman.setStyle("-fx-border-color: black");
		}
		UIPlayerPlayingFunction.getChildren().add(labelHuman);

		showAIPlayerLabel();
		humanHandBox2.getChildren().add(drawRigging);

		showOtherPlayerRecentlyPlay();

		mainBox.setAlignment(Pos.BOTTOM_CENTER);
		mainBox.getChildren().add(tableBox);
		mainBox.getChildren().add(deck);
		mainBox.getChildren().add(UIPlayerPlayingFunction);
		mainBox.getChildren().add(pBox);
		mainBox.getChildren().add(humanHandBox);
		mainBox.getChildren().add(humanHandBox2);
		mainBox.getChildren().add(humanHandBox3);
		mainBox.getChildren().add(humanHandBox4);
		mainBox.getChildren().add(humanHandBox5);

		aPane.getChildren().addAll(mainBox);
		currentStage.setScene(new Scene(aPane, 1600, 1200));
		currentStage.show();

		
		drawRigging.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deck.setPrefHeight(200);
				deck.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
						+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
				deck.setVgap(10);
				deck.setHgap(1);
				Button theContinue= new Button("Continue");
				if(human==1)
				{
					showDeck(0);
				}
				if(human==2)
				{
					showDeck(5);
				}
				if(human==3)
				{
					showDeck(6);
				}
				if(human==4)
				{
					showDeck(7);
				}
				showHandTiles(human);
				humanHandBox2.getChildren().add(theContinue);
				// showMainScene();
				theContinue.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						deck.getChildren().clear();
						humanHandBox2.getChildren().remove(theContinue);

					}
				});

			}
		});
		button789.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				game.getHumanPlayer(human).TilesAscendingOrderByColor();
				showHandTiles(human);
				// showMainScene();

			}
		});
		button777.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				game.getHumanPlayer(human).TilesAscendingOrderByNumber();
				showHandTiles(human);
				// showMainScene();
			}
		});

		buttonDraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateTimer.stop();
				game.getHumanPlayer(human).draw(game.getDeck().myNextTiles());
				playWithAIPlayer();
				checkWinner(s);
				showHandTiles(human);
				showTable(human);
				showAIPlayerLabel();
				showOtherPlayerRecentlyPlay();
				updateDeck();
				
				//Two human and AI strategy 1
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}

				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}

				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//Two human and strategy 2 
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//doing two human player and AI strategy 3
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//One human and AI 1 and AI 2
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
					
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
					
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//One human player and AI 1 and AI 3
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				
				//One human Player and AI 2 and AI 3
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}

				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}

				if (cBox5.getValue().toString().equals("Yourself(1), Human Player(2)") || cBox5.getValue().toString().equals("Human Player(1), Yourself(2)")) 
				{
					if(human==1)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
	
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				//AI player 1 and human Player 1
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 1 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 1 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself(2), Human Player (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 1 (2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 1 (2), Yourself (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				//doing humanPlayer and AI player2 
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 2 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 2 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself(2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 2 (2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 2 (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				
				//doing human Player and AI player 3
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 3 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 3 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself(2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), Human Player (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player (2), Yourself (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 3 (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				//All of Human Player
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 3 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 3 (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 1 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 2 (3), Human Player 1 (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 3 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Human Player 3 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Yourself (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Human Player 2 (3), Yourself (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 3 (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Human Player 3 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Yourself (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Human Player 1 (3), Yourself (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				
			}
		});

		buttonBuildMeld.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				copyMeld(human);
				game.getHumanPlayer(human).clearTestMeld();
				showHandTiles(human);
				showTable(human);
				showAIPlayerLabel();
				showOtherPlayerRecentlyPlay();
				updateDeck();
				// showMainScene();

			}
		});
		 buttonP.setOnAction(new EventHandler<ActionEvent>() {
			  
			  @Override 
			  public void handle(ActionEvent event) {
			  checkPutTilesInTableMelds(human);
			  showHandTiles(human);
			  showTable(human);
			  showAIPlayerLabel();
			  showOtherPlayerRecentlyPlay();
			  updateDeck();
			  } });

		buttonDone.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateTimer.stop();
				checkInitial30(human);
				checkWinner(s);
				showHandTiles(human);
				showTable(human);
				showAIPlayerLabel();
				showOtherPlayerRecentlyPlay();
				updateDeck();
				//Two human and AI strategy 1
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}

				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}

				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//Two human and strategy 2 
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//doing two human player and AI strategy 3
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Human Player 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(2,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);
					}
					if(human==3)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//One human and AI 1 and AI 2
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
					
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
					
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				//One human player and AI 1 and AI 3
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				
				//One human Player and AI 2 and AI 3
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}

				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);
					}
				}
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player(2)") || cBox5.getValue().toString().equals("Human Player(1), Yourself(2)")) 
				{
					if(human==1)
					{
					updateTimer.stop();
					showMainScene(2,s);
					checkWinner(s);
	
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				//AI player 1 and human Player 1
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 1 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 1 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself(2), Human Player (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 1 (2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 1 (2), Yourself (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer1Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				//doing humanPlayer and AI player2 
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 2 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 2 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself(2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 2 (2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 2 (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer2Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				
				//doing human Player and AI player 3
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 3 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 3 (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}

				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself(2), Human Player (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), Human Player (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player (2), Yourself (3)")) {
					if(human==1)
					{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 3 (2), Yourself (3)")) {

					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					game.AIplayer3Play();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				
				if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 3 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 3 (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 1 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 2 (3), Human Player 1 (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 3 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Human Player 3 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Yourself (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Human Player 2 (3), Yourself (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 3 (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), Human Player 3 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Human Player 3 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Yourself (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Human Player 1 (3), Yourself (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}
				if (cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")
						|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) 
				{
					if(human==1)
					{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
					}
					if(human==2)
					{
					updateTimer.stop();
					showMainScene(3,s);
					checkWinner(s);

					}
					if(human==3)
					{
						updateTimer.stop();
						showMainScene(4,s);
						checkWinner(s);
					}
					if(human==4)
					{
					updateTimer.stop();
					showMainScene(1,s);
					checkWinner(s);

					}
				}

			}
		});
		
	}
	

	public void copyMeld(int human)
	{
		game.getTable()[game.getTableIndex()] = new Meld();
		for (int i = 0; i < game.getHumanPlayer(human).numberCheckMeld(); i++) {
			game.getHumanPlayer(human).removeTheTilesByGivenDetail(
					game.getHumanPlayer(human).theCheckMeld()[i].getColorValue(),
					game.getHumanPlayer(human).theCheckMeld()[i].getValue());				
			game.getHumanPlayer(human).addTilesOnInitial30(game.getHumanPlayer(human).theCheckMeld()[i].getValue());
			game.getTable()[game.getTableIndex()].copy(game.getHumanPlayer(human).theCheckMeld()[i]);
		}
		game.getTableIndexPlus1();
		playerHumanPlayMelds += 1;

	}
	
	public void gameRiggingIntoTable(Meld t)
	{
		if (game.checkIsSet() == true || game.checkIsRun() == true) {
			game.getTable()[game.getTableIndex()] = new Meld();

			for (int i = 0; i < game.numberCheckMeld(); i++) {
				game.removeNewDeck(game.theCheckMeld()[i].getColor(),
						game.theCheckMeld()[i].getValue());
				game.getTable()[game.getTableIndex()].copy(game.theCheckMeld()[i]);
			}
			game.getTableIndexPlus1();
		} 
		
		game.tableDisplay();
		game.clearTestMeld();
		showDeck(4);
	}

	
	private boolean canBeSplit(Meld meld) {
		if (meld.getNumOfTiles() < 6) {
			return false;
		}
		
		for (int i = 1; i < meld.getNumOfTiles(); i++) {
			if (meld.getTiles()[i-1].getValue() != meld.getTiles()[i].getValue()-1 ) {
				return true;
			}
		}
		return false;
	}
	
	private void splitMeld(int index) {
		Meld meld = game.getMeld(index);
		int splitIndex = 0;
		for (int i = 1; i < meld.getNumOfTiles(); i++) {
			if (meld.getTiles()[i-1].getValue() != meld.getTiles()[i].getValue()-1 ) {
				splitIndex = i;
				break;
			}
		}
		
		if (splitIndex < 3) {
			throw new RuntimeException("the split index: " + splitIndex);
		}
		
		Meld newMeld = new Meld();
		
		// create a new meld
		for (int i = splitIndex; i < meld.getNumOfTiles(); i++) {
			newMeld.copy(meld.getTiles()[i]);
		}
		
		// remove the tiles from the existing meld
		int numOfTilesToBeRemoved = meld.getNumOfTiles() - splitIndex;
		for (int i = 0; i < numOfTilesToBeRemoved; i++) {
			meld.removeTilesTail();
		}
		
		game.getTable()[game.getTableIndex()] = newMeld;
		game.getTableIndexPlus1();
		
	}
	
	public boolean checkTableValid()
	{
		List<Integer> splitList = new ArrayList<>();
		for (int i = 0; i < game.getTableIndex(); i++) 
		{
			Meld meld = game.getMeld(i);
			if(!meld.checkIsRun() && !meld.checkIsSet())
			{
				System.out.println("meld is not valid: " + i);
				if (canBeSplit(meld)) {
					splitList.add(i);
				} else {
					return false;
				}
			}
		}
		
		for (int i: splitList) {
			splitMeld(i);
		}
		
		return true;
	}
	public void checkInitial30(int human) {
		if (humanPlayerFirstTurn == 1) {
			if (game.getHumanPlayer(human).getInitial30() < 30) {
				for (int i = (game.getTableIndex() - playerHumanPlayMelds); i < game.getTableIndex(); i++) {
					for (int j = 0; j < game.getTable()[i].getNumOfTiles(); j++) {
						game.getHumanPlayer(human).draw(game.getTable()[i].getTiles()[j]);
					}
					game.getTable()[i] = null;
				}
				game.getTableIndexMinus(playerHumanPlayMelds);
				
				for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
					if (game.getHumanPlayer(human).theTiles()[i].getColor() == TileColor.Black) {
						game.getHumanPlayer(human).theTiles()[i].setValue(20);
					}
				}
				for (int i = 0; i < game.getHumanPlayer(human).getNumberTableReuse(); i++) {
					game.getTable()[theTableIndex[i]].copy(game.getHumanPlayer(human).getTableReuseMeld()[i]);
					game.getTable()[theTableIndex[i]].TilesAscendingOrderByColor();
				}

				for(int i=0;i<3;i++)
				{
				game.getHumanPlayer(human).draw(game.getDeck().myNextTiles());
				}
				playWithAIPlayer();

				playerHumanPlayMelds = 0;
				game.getHumanPlayer(human).initial30ToZero();
				// showMainScene();

			} else if (game.getHumanPlayer(human).getInitial30() >= 30) {
				
				if(checkTableValid()==false)
				{
					for (int i = (game.getTableIndex() - playerHumanPlayMelds); i < game.getTableIndex(); i++) {
						for (int j = 0; j < game.getTable()[i].getNumOfTiles(); j++) {
							game.getHumanPlayer(human).draw(game.getTable()[i].getTiles()[j]);
						}
						game.getTable()[i] = null;
					}

					
					game.getTableIndexMinus(playerHumanPlayMelds);
					for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
						if (game.getHumanPlayer(human).theTiles()[i].getColor() == TileColor.Black) {
							game.getHumanPlayer(human).theTiles()[i].setValue(20);
						}
					}
					for (int i = 0; i < game.getHumanPlayer(human).getNumberTableReuse(); i++) {
						game.getTable()[theTableIndex[i]].copy(game.getHumanPlayer(human).getTableReuseMeld()[i]);
						game.getTable()[theTableIndex[i]].TilesAscendingOrderByColor();
					}
					for(int i=0;i<3;i++)
					{
					game.getHumanPlayer(human).draw(game.getDeck().myNextTiles());
					}
					playWithAIPlayer();

				}
				else
				{
				humanPlayerFirstTurn += 1;
				playWithAIPlayer();
				}
				// screenAfterPassInitial30();
			}
		} else if (humanPlayerFirstTurn > 1) {
			if (game.getHumanPlayer(human).getInitial30() == 0) {
				game.getHumanPlayer(human).draw(game.getDeck().myNextTiles());
				playWithAIPlayer();
				// screenAfterPassInitial30();
			} else {
				if(checkTableValid()==false)
				{
					for (int i = (game.getTableIndex() - playerHumanPlayMelds); i < game.getTableIndex(); i++) {
						for (int j = 0; j < game.getTable()[i].getNumOfTiles(); j++) {
							game.getHumanPlayer(human).draw(game.getTable()[i].getTiles()[j]);
						}
						game.getTable()[i] = null;
					}
					game.getTableIndexMinus(playerHumanPlayMelds);
					for(int i=0;i<3;i++)
					{
					game.getHumanPlayer(human).draw(game.getDeck().myNextTiles());
					}
					for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
						if (game.getHumanPlayer(human).theTiles()[i].getColor() == TileColor.Black) {
							game.getHumanPlayer(human).theTiles()[i].setValue(20);
						}
					}
					for (int i = 0; i < game.getHumanPlayer(human).getNumberTableReuse(); i++) {
						game.getTable()[theTableIndex[i]].copy(game.getHumanPlayer(human).getTableReuseMeld()[i]);
						game.getTable()[theTableIndex[i]].TilesAscendingOrderByColor();
					}
					playWithAIPlayer();

				}
				humanPlayerFirstTurn += 1;
				playWithAIPlayer();
				// screenAfterPassInitial30();
			}
		}
		

		clearTableIndexSaving();
		game.getHumanPlayer(human).clearTableReuseMeld();
		game.getHumanPlayer(human).clearTestMeld();

		playerHumanPlayMelds = 0;
		game.getHumanPlayer(human).initial30ToZero();

	}

	public void copyTilesToPlayerCheckMeld(Tile t,int human) {
		game.getHumanPlayer(human).checkMeldAdd(t);
		game.getHumanPlayer(human).printCheckMeldTiles();
	}

	public void copyTilesToAIPlayerCheckMeld(Tile t, int num)
	{
		game.getAIPlayer(num).checkMeldAdd(t);
		game.getAIPlayer(num).printCheckMeldTiles();
	}
	public void checkPutTilesInTableMelds(int human) {
		for (int i = 0; i < game.getTableIndex(); i++) {
			String tableIndex = Integer.toString(i);
			final int getTableIndex = i;
			Button button = new Button(tableIndex);
			button.setPrefSize(50, 100);

			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					copyTilesTableSetOrRun(game.getTable()[getTableIndex],human);
					showTable(human);
					showHandTiles(human);
					pBox.getChildren().clear();
				}
			});

			pBox.getChildren().add(button);

		}
	}

	public void copyTilesTableSetOrRun(Meld t,int human) {
		if (t.getType() == MeldType.RUN) {
			if (game.getHumanPlayer(human).checkPutTilesInTableInRun(t) == true) {
				if (game.getHumanPlayer(human).theCheckMeld()[0].getColor() == TileColor.Black) {
					if (t.getTiles()[0].getValue() == 1) {
						game.getHumanPlayer(human).theCheckMeld()[0]
								.setValue(t.getTiles()[t.getNumOfTiles() - 1].getValue() + 1);
					}
					if (t.getTiles()[t.getNumOfTiles() - 1].getValue() == 13) {
						game.getHumanPlayer(human).theCheckMeld()[0].setValue(t.getTiles()[0].getValue() - 1);
					} else {
						game.getHumanPlayer(human).theCheckMeld()[0]
								.setValue(t.getTiles()[t.getNumOfTiles() - 1].getValue() + 1);

					}
				}

				t.copy(game.getHumanPlayer(human).theCheckMeld()[0]);
				game.getHumanPlayer(human).addTilesOnInitial30(game.getHumanPlayer(human).theCheckMeld()[0].getValue());
				t.TilesAscendingOrderByNumber();
				game.getHumanPlayer(human).removeTheTiles();
			}
		} else if (t.getType() == MeldType.SET) {
			if (game.getHumanPlayer(human).checkPutTilesInTableInSet(t) == true) {
				if (game.getHumanPlayer(human).theCheckMeld()[0].getColor() == TileColor.Black) {
					game.getHumanPlayer(human).theCheckMeld()[0].setValue(t.getTiles()[0].getValue());
				}
				game.getHumanPlayer(human).theCheckMeld()[0].setValue(t.getTiles()[0].getValue());
				t.copy(game.getHumanPlayer(human).theCheckMeld()[0]);
				game.getHumanPlayer(human).addTilesOnInitial30(game.getHumanPlayer(human).theCheckMeld()[0].getValue());
				game.getHumanPlayer(human).removeTheTiles();
			}
		}
		game.getHumanPlayer(human).clearTestMeld();
	}

	public void showHandTiles(int human) {
		humanHandBox.getChildren().clear();
		for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
			Button button = new Button(game.getHumanPlayer(human).theTiles()[i].valueToString());
			button.setPrefSize(60, 100);
			final int index = i;
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					humanHandBox.getChildren().remove(event.getSource());
					copyTilesToPlayerCheckMeld(game.getHumanPlayer(human).theTiles()[index],human);
				}
			});
			button.setTextFill(getTextColor(game.getHumanPlayer(human).theTiles()[i].getColor()));
			humanHandBox.getChildren().add(button);

		}
	}
	public void showHandTiles1(int human) {
		theHumanHandBox1.getChildren().clear();
		for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
			Button button = new Button(game.getHumanPlayer(human).theTiles()[i].valueToString());
			button.setPrefSize(60, 100);
			final int index = i;
			
			button.setTextFill(getTextColor(game.getHumanPlayer(human).theTiles()[i].getColor()));
			theHumanHandBox1.getChildren().add(button);

		}
	}
	public void showHandTiles2(int human) {
		theHumanHandBox2.getChildren().clear();
		for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
			Button button = new Button(game.getHumanPlayer(human).theTiles()[i].valueToString());
			button.setPrefSize(60, 100);
			final int index = i;
			
			button.setTextFill(getTextColor(game.getHumanPlayer(human).theTiles()[i].getColor()));
			theHumanHandBox2.getChildren().add(button);

		}
	}
	public void showHandTiles3(int human) {
		theHumanHandBox3.getChildren().clear();
		for (int i = 0; i < game.getHumanPlayer(human).getNumTiles(); i++) {
			Button button = new Button(game.getHumanPlayer(human).theTiles()[i].valueToString());
			button.setPrefSize(60, 100);
			final int index = i;
			button.setTextFill(getTextColor(game.getHumanPlayer(human).theTiles()[i].getColor()));
			theHumanHandBox3.getChildren().add(button);

		}
	}

	public void showAIPlayerTiles(int num)
	{
		AIPlayerHandBox.getChildren().clear();
		for (int i = 0; i < game.getAIPlayer(num).getNumTiles(); i++) {
			Button button = new Button(game.getAIPlayer(num).theTiles()[i].valueToString());
			button.setPrefSize(60, 80);
			final int index = i;
			button.setTextFill(getTextColor(game.getAIPlayer(num).theTiles()[i].getColor()));
			AIPlayerHandBox.getChildren().add(button);

		}
	}
	public void showAIPlayerTiles2(int num)
	{
		AIPlayerHandBox2.getChildren().clear();
		for (int i = 0; i < game.getAIPlayer(num).getNumTiles(); i++) {
			Button button = new Button(game.getAIPlayer(num).theTiles()[i].valueToString());
			button.setPrefSize(60, 80);
			final int index = i;
			button.setTextFill(getTextColor(game.getAIPlayer(num).theTiles()[i].getColor()));
			AIPlayerHandBox2.getChildren().add(button);

		}
	}
	public void showAIPlayerTiles3(int num)
	{
		AIPlayerHandBox3.getChildren().clear();
		for (int i = 0; i < game.getAIPlayer(num).getNumTiles(); i++) {
			Button button = new Button(game.getAIPlayer(num).theTiles()[i].valueToString());
			button.setPrefSize(60, 80);
			final int index = i;
			button.setTextFill(getTextColor(game.getAIPlayer(num).theTiles()[i].getColor()));
			AIPlayerHandBox3.getChildren().add(button);

		}
	}
	public void showDeck(int player)
	{
		deck.getChildren().clear();
		for(int i=0;i<game.getRiggingDeck().theNumOfTiles();i++)
		{
			Button button = new Button(game.getRiggingDeck().getTile()[i].valueToString());
			button.setPrefSize(60, 40);
			final int index=i;
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					deck.getChildren().remove(event.getSource());
					if(player==0)
					{
						game.getHumanPlayer(1).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showHandTiles(1);
						game.getHumanPlayer(1).printTiles();
						showDeck(0);

					}
					if(player==1)
					{
						game.getAIPlayer(1).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showAIPlayerTiles(1);
						game.getAIPlayer(1).printTiles();
						showDeck(1);

					}
					if(player==2)
					{
						game.getAIPlayer(2).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showAIPlayerTiles(2);
						game.getAIPlayer(2).printTiles();
						showDeck(2);

					}
					if(player==3)
					{
						game.getAIPlayer(3).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showAIPlayerTiles(3);
						game.getAIPlayer(3).printTiles();
						showDeck(3);

					}
					if(player==4)
					{
						game.checkMeldAdd(game.getRiggingDeck().getTile()[index]);
					}
					if(player==5)
					{
						game.getHumanPlayer(2).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showHandTiles(2);
						game.getHumanPlayer(2).printTiles();
						showDeck(5);

					}
					if(player==6)
					{
						game.getHumanPlayer(3).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showHandTiles(3);
						game.getHumanPlayer(3).printTiles();
						showDeck(6);

					}
					if(player==7)
					{
						game.getHumanPlayer(4).draw(game.getRiggingDeck().getTile()[index]);
						game.removeNewDeck(game.getRiggingDeck().getTile()[index].getColor(),
								game.getRiggingDeck().getTile()[index].getValue());
						showHandTiles(4);
						game.getHumanPlayer(4).printTiles();
						showDeck(7);

					}
				}
			});
			button.setTextFill(getTextColor(game.getRiggingDeck().getTile()[i].getColor()));
			deck.getChildren().add(button);

		}

	}
	
	public void playerRecentlyPlayTiles(int j) {
		HBox meldBox = new HBox();

		for (int i = 0; i < game.getAIPlayer(j).getNumberRecentlyPlayTile(); i++) {

			Button button = new Button(game.getAIPlayer(j).getPlayerRecentlyTile()[i].valueToString());
			button.setPrefSize(40, 50);
			button.setTextFill(getTextColor(game.getAIPlayer(j).getPlayerRecentlyTile()[i].getColor()));

			meldBox.getChildren().add(button);

		}
		if (j == 1) {
			humanHandBox3.getChildren().add(meldBox);
		}
		if (j == 2) {
			humanHandBox4.getChildren().add(meldBox);
		}
		if (j == 3) {
			humanHandBox5.getChildren().add(meldBox);
		}
	}

	public void showTable(int human) {
		int numOfMelds = game.getTableIndex();
		tableBox.getChildren().clear();
		if (game.getTableIndex() >= 1) {
			for (int i = 0; i < numOfMelds; i++) {
				HBox meldBox = new HBox();
				final int index = i;

				for (int j = 0; j < game.getTable()[i].getNumOfTiles(); j++) {
					final int theJ = j;
					Button button = new Button(game.getTable()[i].getTiles()[j].valueToString());
					button.setPrefSize(60, 80);
					button.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							if (game.getTable()[index].canReuseTheTiles(
									game.getTable()[index].getTiles()[theJ].getColorValue(),
									game.getTable()[index].getTiles()[theJ].getValue())) {
								game.getHumanPlayer(human).checkMeldAdd(game.getTable()[index].getTiles()[theJ]);
								game.getHumanPlayer(human).tableReuseMeldAdd(game.getTable()[index].getTiles()[theJ]);
								game.getTable()[index].removeTilesFindingByTiles(
										game.getTable()[index].getTiles()[theJ].getColorValue(),
										game.getTable()[index].getTiles()[theJ].getValue());
								
								theTableIndex[numOfTableIndex] = index;
								numOfTableIndex += 1;

								System.out.println(theTableIndex[0]);

							}
							showTable(human);

							// screenAfterPassInitial30();
						}
					});
					button.setTextFill(getTextColor(game.getTable()[i].getTiles()[j].getColor()));

					meldBox.getChildren().add(button);
				}
				tableBox.getChildren().add(meldBox);

			}
		}		
	}

	public void clearTableIndexSaving() {
		for (int i = 0; i < numOfTableIndex; i++) {
			theTableIndex[i] = 0;
		}
		numOfTableIndex = 0;
	}

	public void showAIPlayerLabel()
	{

		humanHandBox2.getChildren().clear();
		
		label.setText("AI Player 1 number Of Tiles:" + game.getAIPlayer(1).getNumTiles());
		label.setFont(new Font(18));
		label.setStyle("-fx-border-color: black");
		humanHandBox2.getChildren().add(label);

		label2.setText("AI Player 2 number Of Tiles:" + game.getAIPlayer(2).getNumTiles());
		label2.setFont(new Font(18));
		label2.setStyle("-fx-border-color: black");
		humanHandBox2.getChildren().add(label2);

		label3.setText("AI Player 3 number Of Tiles:" + game.getAIPlayer(3).getNumTiles());
		label3.setFont(new Font(18));
		label3.setStyle("-fx-border-color: black");
		humanHandBox2.getChildren().add(label3);

		
	}
	
	
	public void showOtherPlayerRecentlyPlay()
	{
		humanHandBox3.getChildren().clear();
		humanHandBox4.getChildren().clear();
		humanHandBox5.getChildren().clear();


		label4.setText("AI Player 1 recently play: ");
		label4.setFont(new Font(18));
		label4.setStyle("-fx-border-color: black");
		humanHandBox3.getChildren().add(label4);

		playerRecentlyPlayTiles(1);
		game.getAIPlayer(1).clearRecentlyTableTile();

		label5.setText("AI Player 2 recently play: ");
		label5.setFont(new Font(18));
		label5.setStyle("-fx-border-color: black");
		humanHandBox4.getChildren().add(label5);

		playerRecentlyPlayTiles(2);
		game.getAIPlayer(2).clearRecentlyTableTile();

		label6.setText("AI Player 3 recently play: ");
		label6.setFont(new Font(18));
		label6.setStyle("-fx-border-color: black");
		humanHandBox5.getChildren().add(label6);

		playerRecentlyPlayTiles(3);
		game.getAIPlayer(3).clearRecentlyTableTile();
	}
	private void updateDeck()
	{
		UIPlayerPlayingFunction.getChildren().remove(deckNumberLabel);
		deckNumberLabel.setText("Remaining Tiles from deck :" + game.getDeck().theNumOfTiles());
		deckNumberLabel.setFont(new Font(18));
		deckNumberLabel.setStyle("-fx-border-color: black");
		UIPlayerPlayingFunction.getChildren().add(deckNumberLabel);
	}
	private void createTimer(TextField textField,int human,String s) {
		updateTimer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				--totalTime;
				int minutes = totalTime / 60;
				int seconds = totalTime % 60;
				textField.setText(String.format("Time left: %d:%02d", minutes, seconds));
				if(totalTime<=0)
				{
					updateTimer.stop();
					checkInitial30(human);
					checkWinner(s);
					showHandTiles(human);
					showTable(human);
					showAIPlayerLabel();
					showOtherPlayerRecentlyPlay();
					updateDeck();
					//Two human and AI strategy 1
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}

					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}

					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Human Player 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					//Two human and strategy 2 
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Human Player 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					//doing two human player and AI strategy 3
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 3 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Human Player 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(3,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(2,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);
						}
						if(human==3)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					//One human and AI 1 and AI 2
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
						
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
						
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					//One human player and AI 1 and AI 3
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					
					//One human Player and AI 2 and AI 3
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}

					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);
						}
					}
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player(2)") || cBox5.getValue().toString().equals("Human Player(1), Yourself(2)")) 
					{
						if(human==1)
						{
						updateTimer.stop();
						showMainScene(2,s);
						checkWinner(s);
		
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					//AI player 1 and human Player 1
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 1 (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);

						}

					}
					if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 1 (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Yourself(2), Human Player (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 1 (2), Human Player (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 1 (1), Human Player (2), Yourself (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer1Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 1 (2), Yourself (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer1Play();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					//doing humanPlayer and AI player2 
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 2 (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);

						}

					}
					if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 2 (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}

					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Yourself(2), Human Player (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 2 (2), Human Player (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 2 (1), Human Player (2), Yourself (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer2Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 2 (2), Yourself (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer2Play();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					
					//doing human Player and AI player 3
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player (2), AI player strategy 3 (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);

						}

					}
					if (cBox5.getValue().toString().equals("Human Player(1), Yourself(2), AI player strategy 3 (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}

					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Yourself(2), Human Player (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Yourself (1), AI player strategy 3 (2), Human Player (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("AI player strategy 3 (1), Human Player (2), Yourself (3)")) {
						if(human==1)
						{
							updateTimer.stop();
							game.AIplayer3Play();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Human Player (1), AI player strategy 3 (2), Yourself (3)")) {

						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						game.AIplayer3Play();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					
					if (cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), Human Player 3 (4)")
							|| cBox5.getValue().toString().equals("Yourself(1), Human Player 1 (2), Human Player 3 (3), Human Player 2 (4)")
							|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), Human Player 3 (4)")
							|| cBox5.getValue().toString().equals("Yourself(1), Human Player 2 (2), Human Player 3 (3), Human Player 1 (4)")
							|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 1 (3), Human Player 2 (4)")
							|| cBox5.getValue().toString().equals("Yourself(1), Human Player 3 (2), Human Player 2 (3), Human Player 1 (4)")) 
					{
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);

						}
						if(human==3)
						{
							updateTimer.stop();
							showMainScene(4,s);
							checkWinner(s);
						}
						if(human==4)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), Human Player 3 (4)")
							|| cBox5.getValue().toString().equals("Human Player 1 (1), Yourself (2), Human Player 3 (3), Human Player 2 (4)")
							|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), Human Player 3 (4)")
							|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 2 (2), Human Player 3 (3), Yourself (4)")
							|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Yourself (3), Human Player 2 (4)")
							|| cBox5.getValue().toString().equals("Human Player 1 (1), Human Player 3 (2), Human Player 2 (3), Yourself (4)")) 
					{
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);

						}
						if(human==3)
						{
							updateTimer.stop();
							showMainScene(4,s);
							checkWinner(s);
						}
						if(human==4)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), Human Player 3 (4)")
							|| cBox5.getValue().toString().equals("Human Player 2 (1), Yourself (2), Human Player 3 (3), Human Player 1 (4)")
							|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), Human Player 3 (4)")
							|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 1 (2), Human Player 3 (3), Yourself (4)")
							|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Yourself (3), Human Player 1 (4)")
							|| cBox5.getValue().toString().equals("Human Player 2 (1), Human Player 3 (2), Human Player 1 (3), Yourself (4)")) 
					{
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);

						}
						if(human==3)
						{
							updateTimer.stop();
							showMainScene(4,s);
							checkWinner(s);
						}
						if(human==4)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}
					if (cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)")
							|| cBox5.getValue().toString().equals("Human Player 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)")
							|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)")
							|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)")
							|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)")
							|| cBox5.getValue().toString().equals("Human Player 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)")) 
					{
						if(human==1)
						{
							updateTimer.stop();
							showMainScene(2,s);
							checkWinner(s);
						}
						if(human==2)
						{
						updateTimer.stop();
						showMainScene(3,s);
						checkWinner(s);

						}
						if(human==3)
						{
							updateTimer.stop();
							showMainScene(4,s);
							checkWinner(s);
						}
						if(human==4)
						{
						updateTimer.stop();
						showMainScene(1,s);
						checkWinner(s);

						}
					}

				
				}
			}
		}));
		updateTimer.setCycleCount(Timeline.INDEFINITE);

	}


	private void checkWinner(String s)
	{		// if not winner, start timer

		if (s.equals("Three of Human Player")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(4).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("Two of Human Player and AI player strategy 1")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("Two of Human Player and AI player strategy 2")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("Two of Human Player and AI player strategy 3")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 2")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 3")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("One Human Player with AI player strategy 2 and AI player strategy 3")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("Three of AI player")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		
		if (s.equals("Human Player and AI player strategy 1")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			
		}
		if (s.equals("Human Player and AI player strategy 2")) 
		{
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			
		}
		if (s.equals("Human Player and AI player strategy 3")) 
		{
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			
		}
		
		if (s.equals("AI player strategy 1 and AI player strategy 2")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			
		}
		if (s.equals("AI player strategy 1 and AI player strategy 3")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			
		}
		if (s.equals("AI player strategy 2 and AI player strategy 3")) 
		{
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}

			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			
		}
		
		

		if (s.equals("Human Player")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}

		if (s.equals("AI player strategy 1")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("AI player strategy 2")) 
		{
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		if (s.equals("AI player strategy 3")) 
		{
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				winnerScene(s);
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				winnerScene(s);
			}
		}
		totalTime= TIMEOUT_SECONDS;
		updateTimer.playFromStart();
		
	}
	
	private void winnerScene(String s)
	{
		Pane aPane = new Pane();
		HBox winnerBox= new HBox();

		Label winnerLabel= new Label();
		VBox mainBox = new VBox();
		HBox b1= new HBox();
		HBox b2= new HBox();
		HBox b3= new HBox();
		HBox b4= new HBox();
		mainBox.setSpacing(10);
		Label l1= new Label();
		Label l2= new Label();
		Label l3= new Label();
		Label l4= new Label();
		Label l5= new Label();
		Label l6= new Label();
		Label l7= new Label();

		
		tableBox = new TilePane();
		tableBox.setPrefHeight(400);
		tableBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		tableBox.setHgap(20);
		tableBox.setVgap(20);

	
		 l1.setText("Your tiles  :" );
		 l1.setFont(new Font(30));
		 l1.setStyle("-fx-border-color: black");
		 
		 l2.setText("AI player 1 tiles  :" );
		 l2.setFont(new Font(30));
		 l2.setStyle("-fx-border-color: black");
		 
		 l3.setText("AI player 2 tiles  :" );
		 l3.setFont(new Font(30));
		 l3.setStyle("-fx-border-color: black");
		 
		 l4.setText("AI player 3 tiles  :" );
		 l4.setFont(new Font(30));
		 l4.setStyle("-fx-border-color: black");
		 
		 l5.setText("Human Player 1 tiles  :" );
		 l5.setFont(new Font(30));
		 l5.setStyle("-fx-border-color: black");
		 
		 l6.setText("Human Player 2 tiles  :" );
		 l6.setFont(new Font(30));
		 l6.setStyle("-fx-border-color: black");
		 
		 l7.setText("Human Player 3 tiles  :" );
		 l7.setFont(new Font(30));
		 l7.setStyle("-fx-border-color: black");
		 
		humanHandBox = new TilePane();
		humanHandBox.setHgap(5);
		humanHandBox.setVgap(5);
		humanHandBox.setAlignment(Pos.CENTER);
		
		theHumanHandBox1 = new TilePane();
		theHumanHandBox1.setHgap(5);
		theHumanHandBox1.setVgap(5);
		theHumanHandBox1.setAlignment(Pos.CENTER);
		
		theHumanHandBox2 = new TilePane();
		theHumanHandBox2.setHgap(5);
		theHumanHandBox2.setVgap(5);
		theHumanHandBox2.setAlignment(Pos.CENTER);
		
		theHumanHandBox3 = new TilePane();
		theHumanHandBox3.setHgap(5);
		theHumanHandBox3.setVgap(5);
		theHumanHandBox3.setAlignment(Pos.CENTER);
		
		AIPlayerHandBox= new TilePane();
		AIPlayerHandBox.setPrefHeight(100);
		AIPlayerHandBox.setHgap(5);
		AIPlayerHandBox.setVgap(5);
		AIPlayerHandBox.setAlignment(Pos.CENTER);
		
		AIPlayerHandBox2= new TilePane();
		AIPlayerHandBox2.setPrefHeight(100);
		AIPlayerHandBox2.setHgap(5);
		AIPlayerHandBox2.setVgap(5);
		AIPlayerHandBox2.setAlignment(Pos.CENTER);
		
		AIPlayerHandBox3= new TilePane();
		AIPlayerHandBox3.setPrefHeight(100);
		AIPlayerHandBox3.setHgap(5);
		AIPlayerHandBox3.setVgap(5);
		AIPlayerHandBox3.setAlignment(Pos.CENTER);
		
		
		if (s.equals("Three of Human Player")) 
		{
			 
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(4).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 3 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l6);
			b4.getChildren().add(l7);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showHandTiles2(3);
			showHandTiles3(4);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(theHumanHandBox2);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(theHumanHandBox3);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		
		if (s.equals("Two of Human Player and AI player strategy 1")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 1 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l6);
			b4.getChildren().add(l2);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showHandTiles2(3);
			showAIPlayerTiles(1);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(theHumanHandBox2);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		if (s.equals("Two of Human Player and AI player strategy 2")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 2 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l6);
			b4.getChildren().add(l3);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showHandTiles2(3);
			showAIPlayerTiles(2);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(theHumanHandBox2);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		if (s.equals("Two of Human Player and AI player strategy 3")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 3 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l6);
			b4.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showHandTiles2(3);
			showAIPlayerTiles(3);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(theHumanHandBox2);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 2")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 1 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l2);
			b4.getChildren().add(l3);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showAIPlayerTiles(1);
			showAIPlayerTiles2(2);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		if (s.equals("One Human Player with AI player strategy 1 and AI player strategy 3")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 3 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 1 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l2);
			b4.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showAIPlayerTiles(1);
			showAIPlayerTiles2(3);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		if (s.equals("One Human Player with AI player strategy 2 and AI player strategy 3")) 
		{
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 3 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l3);
			b4.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);
			showAIPlayerTiles(2);
			showAIPlayerTiles2(3);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		if (s.equals("Three of AI player")) 
		{
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 3 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 1 wins ");
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l2);
			b3.getChildren().add(l3);
			b4.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showAIPlayerTiles(1);
			showAIPlayerTiles2(2);
			showAIPlayerTiles2(3);


			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(b4);
			mainBox.getChildren().add(AIPlayerHandBox3);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		
		if (s.equals("Human Player and AI player strategy 1")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l2);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles2(1);
			showAIPlayerTiles(1);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
			
		}
		if (s.equals("Human Player and AI player strategy 2")) 
		{
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 2 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l3);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles2(1);
			showAIPlayerTiles(2);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
			
		}
		if (s.equals("Human Player and AI player strategy 3")) 
		{
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 3 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			b3.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showHandTiles2(1);
			showAIPlayerTiles(3);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
			
		}
		
		
		if (s.equals("AI player strategy 1 and AI player strategy 2")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 2 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			b1.getChildren().add(l1);
			b2.getChildren().add(l2);
			b3.getChildren().add(l3);
			
			showTable(1);
			showHandTiles(1);
			showAIPlayerTiles(1);
			showAIPlayerTiles2(2);


			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
			
		}
		if (s.equals("AI player strategy 1 and AI player strategy 3")) 
		{
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 3 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			b1.getChildren().add(l1);
			b2.getChildren().add(l2);
			b3.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showAIPlayerTiles(1);
			showAIPlayerTiles2(3);


			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
			
		}
		if (s.equals("AI player strategy 2 and AI player strategy 3")) 
		{
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 2 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI Player 3 wins " );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			
			b1.getChildren().add(l1);
			b2.getChildren().add(l3);
			b3.getChildren().add(l4);
			
			showTable(1);
			showHandTiles(1);
			showAIPlayerTiles(2);
			showAIPlayerTiles2(3);


			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(b3);
			mainBox.getChildren().add(AIPlayerHandBox2);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
			
		}
		
		if (s.equals("Human Player")) 
		{
			 
			if(game.getHumanPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("Human Player 1 wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l5);
			showTable(1);
			showHandTiles(1);
			showHandTiles1(2);

			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(theHumanHandBox1);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		
		if (s.equals("AI player strategy 1")) 
		{
			 
			if(game.getAIPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 1 is wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l2);
			showTable(1);
			showAIPlayerTiles(1);
			showHandTiles(1);
			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		
		if (s.equals("AI player strategy 2")) 
		{
			 
			if(game.getAIPlayer(2).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 2 is wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l3);
			showTable(1);
			showAIPlayerTiles(2);
			showHandTiles(1);
			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}
		
		if (s.equals("AI player strategy 3")) 
		{
			 
			if(game.getAIPlayer(3).getNumTiles()==0)
			{
				 winnerLabel.setText("AI player 3 is wins  :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");			
		
			}
			if(game.getHumanPlayer(1).getNumTiles()==0)
			{
				 winnerLabel.setText("You are win :" );
				 winnerLabel.setFont(new Font(30));
				 winnerLabel.setStyle("-fx-border-color: black");
			}
			b1.getChildren().add(l1);
			b2.getChildren().add(l4);
			showTable(1);
			showAIPlayerTiles(3);
			showHandTiles(1);
			winnerBox.getChildren().add(winnerLabel);
			mainBox.getChildren().add(tableBox);
			mainBox.getChildren().add(b1);
			mainBox.getChildren().add(humanHandBox);
			mainBox.getChildren().add(b2);
			mainBox.getChildren().add(AIPlayerHandBox);
			mainBox.getChildren().add(winnerBox);
			aPane.getChildren().addAll(mainBox);
		}

		currentStage.setScene(new Scene(aPane, 1200, 1200));
		currentStage.show();
	}

	public void start(Stage primaryStage) {
		this.currentStage = primaryStage;
		cBox = new ComboBox();
		cBox.getItems().add("2");
		cBox.getItems().add("3");
		cBox.getItems().add("4");
		cBox.getSelectionModel().select(2);
		textAI.setText("choose how many players you want to join");

		continueButton.setPrefSize(200, 100);
		continueButton.setStyle("-fx-font: 20 arial; -fx-base: rgb(163,81,223); " + "-fx-text-fill: rgb(174,151,194);");
		
		quitButton.setPrefSize(200, 100);
		quitButton.setStyle("-fx-font: 20 arial; -fx-base: rgb(163,81,223); " + "-fx-text-fill: rgb(250,217,223);");
		text.setText("welcome to the rummy game");
//		text.setX(200);
//		text.setY(200);
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		text.setFill(Color.RED);
		text.setStrokeWidth(3);
		text.setStroke(Color.BLUE);
		Pane aPane = new Pane();
		VBox mainBox = new VBox();
		mainBox.setAlignment(Pos.CENTER);
		VBox vBox = new VBox(100);
		HBox hBox = new HBox(10);
		HBox hBox1 = new HBox(10);
		hBox1.setAlignment(Pos.BOTTOM_CENTER);
		hBox1.getChildren().add(0, textAI);
		hBox1.getChildren().add(1, cBox);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox.getChildren().add(0, continueButton);
		hBox.getChildren().add(1, quitButton);

		

		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().add(text);
		vBox.getChildren().add(hBox1);
		vBox.getChildren().add(hBox);

		mainBox.getChildren().add(vBox);
		aPane.getChildren().addAll(mainBox);

		primaryStage.setTitle("Rummy Game");
		mainBox.setMinSize(1200, 1000);

		primaryStage.setScene(new Scene(aPane, 1200, 1200));
		primaryStage.show();

		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) quitButton.getScene().getWindow();
				stage.close();
			}
		});

		continueButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int numPlayers = Integer.parseInt(cBox.getValue().toString());

				chooseYourComponentSceen(numPlayers);
			}
		});
		

	}

	public static void main(String[] args) {
		launch(args);
	}
}
