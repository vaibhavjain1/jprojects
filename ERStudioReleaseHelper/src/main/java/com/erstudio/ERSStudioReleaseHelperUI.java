package main.java.com.erstudio;

/**
 * @author akshit.arora
 * for the UI Skeleton
 */

import main.java.com.erstudio.UUIDGenerator.UUIDGenerator;
import main.java.com.erstudio.constants.Constants;
import main.java.com.erstudio.model.UpgradeTypeEnum;
import main.java.com.erstudio.model.GradientPanel;
import main.java.com.erstudio.tsversionchange.ChangeTSVersionNumber;
import main.java.com.erstudio.tsversionchange.UpdateTSExcelGUID;
import main.java.com.erstudio.tsversionchange.model.VersionInputModel;
import main.java.com.erstudio.utility.InputUtils;
import org.apache.commons.codec.binary.StringUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ERSStudioReleaseHelperUI {

    private JLabel labelTSString;
    private JLabel labelDAString;
    private JLabel labelVersionString;
    private JLabel labelNewVersionString;
    private JLabel labelGUID;
    private JTextField textFieldTS;
    private JTextField textVersionStringTS;
    private JTextField textNewVersionStringTS;
    private JTextField textGUIDTS;
    private JTextField textFieldDA;
    private JTextField textVersionStringDA;
    private JTextField textNewVersionStringDA;
    private JTextField textGUIDDA;
    private JButton buttonBrowse;
    private JButton buttonGenerate;
    private JButton buttonChangeVersion;
    private JButton buttonReset;
    private ButtonGroup buttonGroupUpgradeTypeTS;
    private JRadioButton radioButtonMajorMinorUpgradeTS;
    private JRadioButton radioButtonPatchUpgradeTS;
    private ButtonGroup buttonGroupUpgradeTypeDA;
    private JRadioButton radioButtonMajorMinorDA;
    private JRadioButton radioButtonPatchUpgradeDA;
    private JTextArea textAreaStatusTS;
    private JTextArea textAreaStatusDA;
    private JFrame mainFrame;
    private JTabbedPane tabbedPaneUI;
    private JPanel panelTeamServer;
    private JPanel panelDataArchitect;
    private JPanel panelHelp;
    private JScrollPane scrollPaneStatusTS;
    private JScrollPane scrollPaneStatusDA;

    public JPanel initTeamServerUI() {
        panelTeamServer = new GradientPanel();
        panelTeamServer.setLayout(new GridBagLayout());

        labelTSString = new JLabel(Constants.TS_MAIN_FOLDER);
        textFieldTS = new JTextField();
        textFieldTS.setEditable(false);
        buttonBrowse = new JButton(Constants.BROWSE);

        buttonBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedBrowse();
            }
        });

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelTeamServer.add(labelTSString, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textFieldTS.setPreferredSize(new Dimension(200, 30));
        textFieldTS.setBackground(Color.WHITE);
        panelTeamServer.add(textFieldTS, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        buttonBrowse.setPreferredSize(new Dimension(100, 25));
        panelTeamServer.add(buttonBrowse, gridBagConstraints);

        labelVersionString = new JLabel(Constants.STRING_TO_BE_REPLACED);
        textVersionStringTS = new JTextField();

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelTeamServer.add(labelVersionString, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textVersionStringTS.setPreferredSize(new Dimension(200, 30));
        panelTeamServer.add(textVersionStringTS, gridBagConstraints);

        labelNewVersionString = new JLabel(Constants.NEW_VERSION_STRING);
        textNewVersionStringTS = new JTextField();

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelTeamServer.add(labelNewVersionString, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textNewVersionStringTS.setPreferredSize(new Dimension(200, 30));
        panelTeamServer.add(textNewVersionStringTS, gridBagConstraints);

        labelGUID = new JLabel(Constants.GUID);
        textGUIDTS = new JTextField();
        buttonGenerate = new JButton(Constants.GENERATE);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelTeamServer.add(labelGUID, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textGUIDTS.setPreferredSize(new Dimension(200, 30));
        panelTeamServer.add(textGUIDTS, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        buttonGenerate.setPreferredSize(new Dimension(100, 25));
        panelTeamServer.add(buttonGenerate, gridBagConstraints);
        buttonGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedGenerateUUID();
            }
        });

        buttonGroupUpgradeTypeTS = new ButtonGroup();
        radioButtonMajorMinorUpgradeTS = new JRadioButton(Constants.MAJOR_OR_MINOR_UPGRADE);
        radioButtonPatchUpgradeTS = new JRadioButton(Constants.PATCH_UPGRADE);
        buttonGroupUpgradeTypeTS.add(radioButtonMajorMinorUpgradeTS);
        buttonGroupUpgradeTypeTS.add(radioButtonPatchUpgradeTS);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        radioButtonMajorMinorUpgradeTS.setOpaque(false);
        radioButtonMajorMinorUpgradeTS.setSelected(true);
        panelTeamServer.add(radioButtonMajorMinorUpgradeTS, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        radioButtonPatchUpgradeTS.setPreferredSize(new Dimension(120, 25));
        radioButtonPatchUpgradeTS.setOpaque(false);
        panelTeamServer.add(radioButtonPatchUpgradeTS, gridBagConstraints);

        buttonChangeVersion = new JButton(Constants.CHANGE_VERSION_NUMBER);
        buttonChangeVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedChangeVersion();
            }
        });

        buttonReset = new JButton(Constants.RESET);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedReset();
            }
        });

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        panelTeamServer.add(buttonChangeVersion, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        panelTeamServer.add(buttonReset, gridBagConstraints);

        textAreaStatusTS = new JTextArea();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textAreaStatusTS.setEditable(false);
        textAreaStatusTS.setBackground(Color.WHITE);
        scrollPaneStatusTS = new JScrollPane(textAreaStatusTS,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneStatusTS.getVerticalScrollBar().setUnitIncrement(30);
        scrollPaneStatusTS.getHorizontalScrollBar().setUnitIncrement(30);
        scrollPaneStatusTS.setPreferredSize(new Dimension(0, 150));
        panelTeamServer.add(scrollPaneStatusTS, gridBagConstraints);

        return panelTeamServer;
    }

    public JPanel initDataArchitectUI() {
        panelDataArchitect = new GradientPanel();
        panelDataArchitect.setLayout(new GridBagLayout());

        labelDAString = new JLabel(Constants.DA_MAIN_FOLDER);
        textFieldDA = new JTextField();
        textFieldDA.setEditable(false);
        buttonBrowse = new JButton(Constants.BROWSE);

        buttonBrowse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedBrowse();
            }
        });

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelDataArchitect.add(labelDAString, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textFieldDA.setBackground(Color.WHITE);
        textFieldDA.setPreferredSize(new Dimension(200, 30));
        panelDataArchitect.add(textFieldDA, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        buttonBrowse.setPreferredSize(new Dimension(100, 25));
        panelDataArchitect.add(buttonBrowse, gridBagConstraints);

        labelVersionString = new JLabel(Constants.STRING_TO_BE_REPLACED);
        textVersionStringDA = new JTextField();

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelDataArchitect.add(labelVersionString, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textVersionStringDA.setPreferredSize(new Dimension(200, 30));
        panelDataArchitect.add(textVersionStringDA, gridBagConstraints);

        labelNewVersionString = new JLabel(Constants.NEW_VERSION_STRING);
        textNewVersionStringDA = new JTextField();

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelDataArchitect.add(labelNewVersionString, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textNewVersionStringDA.setPreferredSize(new Dimension(200, 30));
        panelDataArchitect.add(textNewVersionStringDA, gridBagConstraints);

        labelGUID = new JLabel(Constants.GUID);
        textGUIDDA = new JTextField();
        buttonGenerate = new JButton(Constants.GENERATE);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,15,0,0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelDataArchitect.add(labelGUID, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textGUIDDA.setPreferredSize(new Dimension(200, 30));
        panelDataArchitect.add(textGUIDDA, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        buttonGenerate.setPreferredSize(new Dimension(100, 25));
        panelDataArchitect.add(buttonGenerate, gridBagConstraints);

        buttonGroupUpgradeTypeDA = new ButtonGroup();
        radioButtonMajorMinorDA = new JRadioButton(Constants.MAJOR_OR_MINOR_UPGRADE);
        radioButtonPatchUpgradeDA = new JRadioButton(Constants.PATCH_UPGRADE);
        buttonGroupUpgradeTypeDA.add(radioButtonMajorMinorDA);
        buttonGroupUpgradeTypeDA.add(radioButtonPatchUpgradeDA);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        radioButtonMajorMinorDA.setOpaque(false);
        radioButtonMajorMinorDA.setSelected(true);
        panelDataArchitect.add(radioButtonMajorMinorDA, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        radioButtonPatchUpgradeDA.setPreferredSize(new Dimension(150, 30));
        radioButtonPatchUpgradeDA.setOpaque(false);
        panelDataArchitect.add(radioButtonPatchUpgradeDA, gridBagConstraints);

        buttonChangeVersion = new JButton(Constants.CHANGE_VERSION_NUMBER);
        buttonChangeVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedChangeVersion();
            }
        });

        buttonReset = new JButton(Constants.RESET);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressedReset();
            }
        });

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        panelDataArchitect.add(buttonChangeVersion, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.weightx = .5;
        gridBagConstraints.weighty = .2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new Insets(0,0,0,0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        panelDataArchitect.add(buttonReset, gridBagConstraints);

        textAreaStatusDA = new JTextArea();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        textAreaStatusDA.setEditable(false);
        textAreaStatusDA.setBackground(Color.WHITE);
        scrollPaneStatusDA = new JScrollPane(textAreaStatusDA,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneStatusDA.getVerticalScrollBar().setUnitIncrement(30);
        scrollPaneStatusDA.getHorizontalScrollBar().setUnitIncrement(30);
        scrollPaneStatusDA.setPreferredSize(new Dimension(0, 150));
        panelDataArchitect.add(scrollPaneStatusDA, gridBagConstraints);

        return panelDataArchitect;
    }

    public JPanel initHelpUI() {
        panelHelp = new GradientPanel();
        return panelHelp;
    }

    public void onPressedReset() {
        if (tabbedPaneUI.getTitleAt(tabbedPaneUI.getSelectedIndex()) == Constants.TEAM_SERVER) {
            textFieldTS.setText("");
            textFieldTS.setBackground(Color.WHITE);
            textVersionStringTS.setText("");
            textVersionStringTS.setBackground(Color.WHITE);
            textNewVersionStringTS.setText("");
            textNewVersionStringTS.setBackground(Color.WHITE);
            buttonGroupUpgradeTypeTS.clearSelection();
            textGUIDTS.setText("");
            textGUIDTS.setBackground(Color.WHITE);
            textAreaStatusTS.setText("");
        }
        if (tabbedPaneUI.getTitleAt(tabbedPaneUI.getSelectedIndex()) == Constants.DATA_ARCHITECT) {
            textFieldDA.setText("");
            textFieldDA.setBackground(Color.white);
            textVersionStringDA.setText("");
            textVersionStringDA.setBackground(Color.WHITE);
            textNewVersionStringDA.setText("");
            textNewVersionStringDA.setBackground(Color.WHITE);
            textNewVersionStringDA.setBackground(Color.WHITE);
            buttonGroupUpgradeTypeDA.clearSelection();
            textGUIDDA.setText("");
            textGUIDDA.setBackground(Color.WHITE);
            textAreaStatusDA.setText("");
        }
    }

    // map the components from GUI to the model
    public void copyComponentsFromGUI(VersionInputModel versionInputModel) {
    	if(versionInputModel.getProductName().equals(Constants.TEAM_SERVER)) {
	        if (radioButtonMajorMinorUpgradeTS.isSelected()) {
	            versionInputModel.setUpgradeType(UpgradeTypeEnum.MAJOR_OR_MINOR_UPGRADE);
	        } else {
	            versionInputModel.setUpgradeType(UpgradeTypeEnum.PATCH_UPGRADE);
	        }
	        if (textFieldTS != null)
	            versionInputModel.setFilePath(textFieldTS.getText());
	        if (textVersionStringTS != null)
	            versionInputModel.setOldVersion(textVersionStringTS.getText());
	        if (textNewVersionStringTS != null)
	            versionInputModel.setNewVersion(textNewVersionStringTS.getText());
	        if (textGUIDTS != null)
	            versionInputModel.setGUID(textGUIDTS.getToolTipText());
    	}
    	else {
    		if (radioButtonMajorMinorDA.isSelected()) {
	            versionInputModel.setUpgradeType(UpgradeTypeEnum.MAJOR_OR_MINOR_UPGRADE);
	        } else {
	            versionInputModel.setUpgradeType(UpgradeTypeEnum.PATCH_UPGRADE);
	        }
	        if (textFieldDA != null)
	            versionInputModel.setFilePath(textFieldDA.getText());
	        if (textVersionStringDA != null)
	            versionInputModel.setOldVersion(textVersionStringDA.getText());
	        if (textNewVersionStringDA != null)
	            versionInputModel.setNewVersion(textNewVersionStringDA.getText());
	        if (textGUIDDA != null)
	            versionInputModel.setGUID(textGUIDDA.getToolTipText());
    	}
    }

    public void onPressedGenerateUUID() {
        UUID guid = UUIDGenerator.generateUUID();
        String strGuid  =UUIDGenerator.toEllipsis(guid, 28, 6);
        if (tabbedPaneUI.getTitleAt(tabbedPaneUI.getSelectedIndex()) == Constants.TEAM_SERVER) {
            UpdateTSExcelGUID updateTSExcelGUID = new UpdateTSExcelGUID(Constants.VERSION_HELPER_SHEET);
            List<String> response = updateTSExcelGUID.update(guid);
            updateStatusText(response, Constants.TEAM_SERVER);
        }
        textGUIDTS.setText(strGuid.toUpperCase());
        textGUIDTS.setToolTipText(guid.toString().toUpperCase());
    }

    public void onPressedChangeVersion() {
    	String productName = tabbedPaneUI.getTitleAt(tabbedPaneUI.getSelectedIndex());
        if (validateInput(productName)) {
            textAreaStatusTS.setText("");
            VersionInputModel versionInputModel = new VersionInputModel("", "", "", "", UpgradeTypeEnum.PATCH_UPGRADE, productName);
            copyComponentsFromGUI(versionInputModel);
            List<String> response = new ArrayList<>();
            ChangeTSVersionNumber changeTSVersionNumber = null;
            try {
                changeTSVersionNumber = new ChangeTSVersionNumber(versionInputModel);
                response = changeTSVersionNumber.changeVersion(versionInputModel);
            } catch (Exception e) {
                e.printStackTrace();
                response.add("excel file is either open/delete or corrupted");
            } finally {
                updateStatusText(response, productName);
            }
        }
    }

    public void updateStatusText(List<String> response, String productName) {
    	JTextArea status;
    	if(productName.equals(Constants.TEAM_SERVER))
    		status = textAreaStatusTS;
    	else
    		status = textAreaStatusDA;
        status.setText("");
        String responseStringFinal = "";
        for (String responeString : response) {
            responseStringFinal += "\n" + responeString;
            status.setText(responseStringFinal);
        }
    }

    public void onPressedBrowse() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // set the selection mode to directories only
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // invoke the showsOpenDialog function to show the save dialog
        int stateFileChooser = fileChooser.showOpenDialog(null);

        if (stateFileChooser == JFileChooser.APPROVE_OPTION) {
            // set the label to the path of the selected directory
            if (tabbedPaneUI.getTitleAt(tabbedPaneUI.getSelectedIndex()).equals(Constants.TEAM_SERVER)) {
                textFieldTS.setText(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                textFieldDA.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    // method to validate input
    public boolean validateInput(String projectName) {
        boolean validationFlag = true;
        if (projectName.equals(Constants.TEAM_SERVER)) {
            if (!InputUtils.isValidDirectory(projectName, textFieldTS.getText())) {
                textFieldTS.setBackground(new Color(255, 153, 153));
                textFieldTS.setToolTipText(Constants.ERS_STUDIO_DIRECTORY_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textFieldTS.setBackground(tabbedPaneUI.getSelectedComponent().getBackground());
                textFieldTS.setToolTipText(null);
            }
            if (!InputUtils.isValidVersionNumber(projectName, textVersionStringTS.getText())) {
                textVersionStringTS.setBackground(new Color(255, 153, 153));
                textVersionStringTS.setToolTipText(Constants.ERS_STUDIO_CHANGE_VERSION_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textVersionStringTS.setBackground(Color.WHITE);
                textVersionStringTS.setToolTipText(null);
            }
            if (!InputUtils.isValidVersionNumber(projectName, textNewVersionStringTS.getText())) {
                textNewVersionStringTS.setBackground(new Color(255, 153, 153));
                textNewVersionStringTS.setToolTipText(Constants.ERS_STUDIO_NEW_VERSION_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textNewVersionStringTS.setBackground(Color.WHITE);
                textNewVersionStringTS.setToolTipText(null);
            }
            if (radioButtonMajorMinorUpgradeTS.isSelected() && textGUIDTS.getText().isEmpty()) {
                textGUIDTS.setBackground(new Color(255, 153, 153));
                textGUIDTS.setToolTipText(Constants.ERS_STUDIO_GUID_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textGUIDTS.setBackground(Color.WHITE);
            }
        }

        if (projectName.equals(Constants.DATA_ARCHITECT)) {
            if (!InputUtils.isValidDirectory(projectName, textFieldDA.getText())) {
                textFieldDA.setBackground(new Color(255, 153, 153));
                textFieldDA.setToolTipText(Constants.DA_DIRECTORY_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textFieldDA.setBackground(tabbedPaneUI.getSelectedComponent().getBackground());
                textFieldDA.setToolTipText(null);
            }
            if (!InputUtils.isValidVersionNumber(projectName, textVersionStringDA.getText())) {
                textVersionStringDA.setBackground(new Color(255, 153, 153));
                textVersionStringDA.setToolTipText(Constants.DA_CHANGE_VERSION_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textVersionStringDA.setBackground(Color.WHITE);
                textVersionStringDA.setToolTipText(null);
            }
            if (!InputUtils.isValidVersionNumber(projectName, textNewVersionStringDA.getText())) {
                textNewVersionStringDA.setBackground(new Color(255, 153, 153));
                textNewVersionStringDA.setToolTipText(Constants.DA_NEW_VERSION_VALIDATION_ERROR);
                validationFlag = false;
            } else {
                textNewVersionStringDA.setBackground(Color.WHITE);
                textNewVersionStringDA.setToolTipText(null);
            }
        }

        return validationFlag;
    }

    public ERSStudioReleaseHelperUI() {
        mainFrame = new JFrame(Constants.ERS_STUDIO_RELEASE_HELPER);

        tabbedPaneUI = new JTabbedPane();
        tabbedPaneUI.setBounds(50, 50, 570, 570);

        JPanel panelTeamServerUI = initTeamServerUI();
        JPanel panelDataArchitectUI = initDataArchitectUI();
        JPanel panelHelpUI = initHelpUI();

        tabbedPaneUI.add(Constants.TEAM_SERVER, panelTeamServerUI);
        tabbedPaneUI.add(Constants.DATA_ARCHITECT, panelDataArchitectUI);
        tabbedPaneUI.add(Constants.HELP, panelHelpUI);

        mainFrame.add(tabbedPaneUI);
        mainFrame.setSize(570, 570);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

}
