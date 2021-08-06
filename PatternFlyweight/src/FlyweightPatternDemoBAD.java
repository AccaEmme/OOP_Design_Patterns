import java.awt.Color;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;

/*
è un pattern che permette di separare la parte variabile di una classe
dalla parte che può essere riutilizzata, in modo tale da condividere quest'ultima
fra differenti istanze. L'oggetto Flyweight deve essere un oggetto immutabile
per permettere a condivisione tra diversi client e thread.

Esempio di progettazione di un word processor:
l'oggetto glifo dovrebbe contenere informazioni come:
  font, dimensione, colore e dimensione per ogni carattere

Il problema è che un testo lungo potrebbe contenere migliaia di caratteri e oggetti.

Il pattern Flyweight risolve il problema creando un nuovo oggetto per memorizzare quelle
informazioni che sono condivise da tutti i caratteri con la stessa formattazione.

Memorizzando le informazioni una volta sola si ha un grosso risparmio di memoria.
 */

enum FontEffect{
	BOLD, ITALIC, SUPERSCRIPT, SUBSCRIPT, STRIKETHROUGH
}

final class FontData{
	// un weak reference rappresenta un riferimento debole, ovvero un riferimento a un oggetto che può ancora essere ancora dalla procedura di Garbace Collection.
	private static final WeakHashMap<FontData, WeakReference<FontData>> flyweightData = new WeakHashMap<FontData, WeakReference<FontData>>(); 
	private final int 				pointSize;
	private final String			fontFace;
	private final Color				color;
	private final Set<FontEffect> 	effects;
	
	public static FontData create(
									int pointSize,
									String fontFace,
									Color color,
									FontEffect...effects
							) {
		EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
        for (FontEffect fontEffect : effects) {
            effectsSet.add(fontEffect);
        }
        // We are unconcerned with object creation cost, we are reducing overall memory consumption
        FontData data = new FontData(pointSize, fontFace, color, effectsSet);
        if (!flyweightData.containsKey(data)) {
            flyweightData.put(data, new WeakReference(data));
        }
        // return the single immutable copy with the given values
        return flyweightData.get(data).get();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FontData other = (FontData) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (effects == null) {
            if (other.effects != null)
                return false;
        } else if (!effects.equals(other.effects))
            return false;
        if (fontFace == null) {
            if (other.fontFace != null)
                return false;
        } else if (!fontFace.equals(other.fontFace))
            return false;
        if (pointSize != other.pointSize)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((effects == null) ? 0 : effects.hashCode());
        result = prime * result + ((fontFace == null) ? 0 : fontFace.hashCode());
        result = prime * result + pointSize;
        return result;
    }

    // Getters for the font data, but no setters. FontData is immutable.
	
}


public class FlyweightPatternDemoBAD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
